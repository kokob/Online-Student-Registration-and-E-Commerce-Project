<%-- 
    Document   : addCourse
    Created on : Oct 14, 2014, 1:41:07 PM
    Author     : b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <fieldset>
            <form action="addCourse" method="post">
                <div>
                    <legend>New Course</legend>
                    <label>Course Name:</label> <input type="text" name="name" /> 
                    <label>Course Code:</label> <input type="text" name="code" /> 
                    <label>Credit Hours:</label> <input type="text" name="credit"/> 
                    <label><input type="submit" value="Add Course"/></label>
                </div>
            </form>
        </fieldset>
    </body>
</html>
