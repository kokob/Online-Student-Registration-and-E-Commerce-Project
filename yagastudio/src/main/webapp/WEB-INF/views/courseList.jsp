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
		<li>course name: ${course.courseName}</li>
		<li>course code: ${course.courseCode}</li>
		<li>course credit:${course.courseCredit}</li>		
		<a href="course/${course.id}">edit</a>
                  </ul>
	</fieldset>
	</c:forEach>
	</fieldset>	
<!--	<a href="addCar.html"> Add a Car</a>-->
    </body>
</html>
