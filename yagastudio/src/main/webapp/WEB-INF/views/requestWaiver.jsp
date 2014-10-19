<%-- 
    Document   : requestWaiver
    Created on : Oct 17, 2014, 3:08:08 PM
    Author     : b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>${noPrerequisiteMessage}</h3>
        <h3>Thank you ${currentCustomer.firstName}</h3>
        <a href="../viewCourses">Back to Courses</a>
    </body>
</html>
