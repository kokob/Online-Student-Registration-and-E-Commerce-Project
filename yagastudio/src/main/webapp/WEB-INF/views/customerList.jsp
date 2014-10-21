<%-- 
    Document   : customersList
    Created on : Oct 17, 2014, 7:08:43 PM
    Autdor     : zeriet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>Yoga Studio</title>

    </head>
    <div id="container">
        <body>
            <div id="body">
                <jsp:include page="/WEB-INF/views/header.jsp"/> 
                <h1>List of customers</h1>

                <table class="CSSTableGenerator" style="width:70%">
                    <tr>
                        <td>First Name</td>
                        <td>Last Name</td>
                        <td>Email</td>
                        <td>Profile image</td>
                        <td>Operation</td>
                    </tr>
                    <c:forEach var="customer" items="${customers}">               
                        <tr>
                            <td class="tg-hv32">${customer.firstName}</td>
                            <td class="tg-bsv2">${customer.lastName}</td>
                            <td class="tg-bsv2">${customer.email}</td>
                            <td class="tg-bsv2"> <img src="customerpic/${customer.id}" /></td>
                            <td class="tg-bsv2"> <a href="customer/${customer.id}">edit</a>
                            </td>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>
