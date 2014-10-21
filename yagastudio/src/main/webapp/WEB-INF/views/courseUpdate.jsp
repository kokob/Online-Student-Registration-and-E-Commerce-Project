<%-- 
    Document   : courseUpdateDelete
    Created on : Oct 15, 2014, 11:48:12 PM
    Author     : zeriet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../resources/style.css" rel="stylesheet" type="text/css" />
        <title>Yoga Studio</title>

    </head>
    <div id="container">
        <body>
            <div id="body">
                <jsp:include page="/WEB-INF/views/header.jsp"/> 
        <fieldset>
            <form action="../course/${course.id}" method="post" class = "basic-grey">      
                
                    <label>Course Name:</label> <input type="text" name="name" value="${course.courseName}" /> 
                    <label>Course Code:</label> <input type="text" name="code" value="${course.courseCode}" /> 
                    <label>Credit Hours:</label> <input type="text" name="credit" value="${course.courseCredit}"/> 
                    <label>Prerequisite: 
                        <select name="prereq_id">
                            <c:forEach var="courses" items="${allcourses}" >
                                <option value="${course.id}">${course.courseName} (${course.courseCode})</option>
                            </c:forEach>
                        </select>
                    </label>
                    <label><input type="submit" value="update"/> </label>
                </div>
            </form>
        </fieldset> </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>