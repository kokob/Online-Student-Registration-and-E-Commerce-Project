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
        <title>JSP Page</title>
    </head>
    <body>
        <form action="addCourse" method="post">
                <table>
                    <tr>
                        <td>Course Name: </td>
                        <td><input type="text" name="name" /> </td>
                    </tr>
                    <tr>
                        <td>Course Code: </td>
                        <td><input type="text" name="code" /> </td>
                    </tr>
                    <tr>
                        <td>Credit Hours: </td>
                        <td><input type="text" name="credit" /> </td>
                    </tr>
                    
                </table>
                <input type="submit" value="Add Course"/>

            </form>
    </body>
</html>
