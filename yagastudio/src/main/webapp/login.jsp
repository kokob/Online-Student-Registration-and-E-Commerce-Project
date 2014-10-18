<%-- 
    Document   : login
    Created on : Oct 16, 2014, 10:28:31 PM
    Author     : kokob
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>login Page</title>
    </head>
    <body>
                <form name='form' action="j_spring_security_check" method='POST'>
                    <table>
                        <tr>
                            <td>User:</td>
                            <td><input type='text' name='j_username'></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type='password' name='j_password' /></td>
                        </tr>
                        <tr>
                            <td><input name="submit" type="submit" value="LogIn" /></td>
                        </tr>
                    </table>
                </form>

    </body>
</html>
