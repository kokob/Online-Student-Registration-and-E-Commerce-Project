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
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
          <fieldset>
        <form action="../course/${course.id}" method="post">      
         <div>
               <input type="text" name="make" value="${car.make}" />	
                    <legend>New Course</legend>
                    <label>Course Name:</label> <input type="text" name="name" value="${course.courseName}" /> 
                    <label>Course Code:</label> <input type="text" name="code" value="${course.courseCode}" /> 
                    <label>Credit Hours:</label> <input type="text" name="credit" value="${course.courseCredit}"/> 
                    <label><input type="submit" value="update"/> </label>
           </div>
	</fieldset>
        </form>
    </body>
</html>
