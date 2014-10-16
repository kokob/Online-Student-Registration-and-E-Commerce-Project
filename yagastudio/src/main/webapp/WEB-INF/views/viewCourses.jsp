<%-- 
    Document   : viewCourses
    Created on : Oct 15, 2014, 3:59:08 PM
    Author     : abel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>List of Courses</title>
    </head>
    <body>
        <div>
                <h1>Courses currently in Yoga Studio</h1>
                
        <fieldset>   
                    <c:forEach var="course" items="${courses}">
                        <label> <a href="courses/${course.id}"> ${course.courseName} </a></label>                        
                    </c:forEach>
               
        </fieldset>
        </div>
    </body>
</html>
