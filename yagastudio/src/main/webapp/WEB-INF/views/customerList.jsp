<%-- 
    Document   : customersList
    Created on : Oct 17, 2014, 7:08:43 PM
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
        <h1>List of customers</h1>

        <table class="tg" style="width:70%">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Operation</th>
            </tr>
            <c:forEach var="customer" items="${customers}">               
                <tr>
                    <th class="tg-hv32">${customer.firstName}</th>
                    <th class="tg-bsv2">${customer.lastName}</th>
                    <th class="tg-bsv2">${customer.email}</th>
                    <th class="tg-bsv2"> <a href="customer/${customer.id}">edit</a>
                <form action="customer/delete?customerId=${customer.id}" method="post">
                    <button type="submit">Delete</button>
                </form></th>
        </tr>
    </c:forEach>
</table>
</body>
</html>