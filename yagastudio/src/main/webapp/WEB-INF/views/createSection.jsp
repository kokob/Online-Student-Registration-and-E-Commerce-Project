<%-- 
    Document   : createSection
    Created on : Oct 15, 2014, 3:56:18 PM
    Author     : b
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>Yoga Studio</title>

    </head>
    <div id="container">
        <body>
            <div id="body">
                <jsp:include page="/WEB-INF/views/header.jsp"/> 
        <h3>Create a Section</h3>
        <fieldset>
            ${allcourses}
            <form action="createSection" method="POST" class = "basic-grey" style="width:300px">        
                <label>Course: 
                <select name="selectedcourse">
                    <c:forEach var="course" items="${allcourses}" >
                        <option value="${course.id}">${course.courseName} ${course.id} &nbsp (${course.courseCode})</option>
                    </c:forEach>
                </select></label>
            
                <label>Faculty:
                <select name="selectedfaculty">
                    <c:forEach var="faculty" items="${allfaculties}" >
                        <option value="${faculty.id}">Professor ${faculty.firstName} &nbsp  ${faculty.lastName}</option>
                    </c:forEach>
                </select></label>
            
                <label>Seats:
                <input type="text" name="seatsavailable" /></label>
            
                <label><input type="submit" value="Add Section" /></label>
            
            
        </form>
        
        </fieldset>
    </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>