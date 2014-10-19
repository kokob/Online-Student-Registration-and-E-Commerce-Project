<%-- 
    Document   : addToWaitlist
    Created on : Oct 17, 2014, 2:21:35 PM
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
        <h3>${section.course.courseCode} by Professor ${section.teacher.lastName} is full.</h3>
      
        <a href="../addToWaitlist">Add to Waitlist</a><br />
            
        <a href="../courses/${section.course.id}">Back to Sections</a>
        
    </body>
</html>
