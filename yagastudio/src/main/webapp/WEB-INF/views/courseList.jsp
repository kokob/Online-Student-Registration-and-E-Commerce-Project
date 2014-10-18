<%-- 
    Document   : courseList
    Created on : Oct 15, 2014, 9:28:17 PM
    Author     : zeriet
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>

        <h1>List of courses</h1>
        <fieldset>
            <c:forEach var="course" items="${courses}">
                <fieldset>
                    <ul>
                        <p><strong>${course.courseName}</strong></p>              
                        <li>course code: ${course.courseCode}</li>
                        <li>course credit:${course.courseCredit}</li>		
                        <a href="course/${course.id}">edit</a>
                        <form action="course/delete?courseId=${course.id}" method="post">
                            <button type="submit">Delete</button>
                        </form>
                    </ul>
                </fieldset>
            </c:forEach>
        </fieldset>

     <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
        <label><a href="index.jsp">Cancel</a></label>
   
        <!--	<a href="addCar.html"> Add a Car</a>-->
    </body>
</html>
