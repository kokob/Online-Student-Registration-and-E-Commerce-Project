<%-- 
    Document   : enrollSuccess
    Created on : Oct 17, 2014, 2:14:12 PM
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
        <h1>You have successfully enrolled in ${section.course.courseName} by Professor ${section.teacher.lastName}</h1>
        <a href="../viewCourses">Back to Courses</a>
    </body>
</html>
