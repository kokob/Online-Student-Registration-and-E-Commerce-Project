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
        <link href="../resources/style.css" rel="stylesheet" type="text/css" />
        <title>Yoga Studio</title>

    </head>
    <div id="container">
        <body>
            <div id="body">
                <jsp:include page="/WEB-INF/views/header.jsp"/> 
                <fieldset>
                    <form action="../customer/${customer.id}" method="post" class = "basic-grey">      
                        <div>            	
                           
                            <label>First Name:</label> <input type="text" name="firstname" value="${customer.firstName}" /> 
                            <label>Last Name:</label> <input type="text" name="lastname" value="${customer.lastName}" /> 
                            <label>email:</label> <input type="text" name="email" value="${customer.email}"/> 
                            <label>User Name:</label> <input type="text" name="username" value="${customer.userName}"/> 
                            <label><input type="submit" value="update"/> </label>

                        </div>

                    </form>
                </fieldset>
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>