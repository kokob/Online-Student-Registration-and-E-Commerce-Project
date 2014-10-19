<%-- 
    Document   : customerUpdateDelete
    Created on : Oct 17, 2014, 9:44:34 PM
    Author     : zeriet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
         <fieldset>
            <form action="../customer/${customer.id}" method="post">      
                <div>              	
                    <legend>Update Customer</legend>
                    <label>First Name:</label> <input type="text" name="firstName" value="${customer.firstName}" /> 
                    <label>Last Name:</label> <input type="text" name="lastName" value="${customer.lastName}" /> 
                    <label>email:</label> <input type="text" name="email" value="${customer.email}"/> 
                    <label><input type="submit" value="update"/> </label>

                </div>

            </form>
        </fieldset>
    </body>
</html>
