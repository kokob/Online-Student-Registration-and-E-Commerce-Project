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
        <p>
            You must take ${no_prereq_course.prerequisite.courseName}(${no_prereq_course.prerequisite.courseCode}) 
            before taking ${no_prereq_course.courseName}(${no_prereq_course.courseCode}).Please consider
            taking ${no_prereq_course.prerequisite.courseName} or 
            
            <a href="../applyForWaiver">Request a Waiver</a> 
            
            for ${no_prereq_course.prerequisite.courseName}
        </p>
        
        <a href="../viewCourses">Back to Courses</a>
        
    </body>
</html>
