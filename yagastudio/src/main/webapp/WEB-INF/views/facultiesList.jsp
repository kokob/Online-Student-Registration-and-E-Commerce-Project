<%-- 
    Document   : facultiesList
    Created on : Oct 17, 2014, 5:43:02 PM
    Autdor     : zeriet
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h2>List of faculties</h2>

                <table class="CSSTableGenerator" style="width:70%">
                    <tr>
                        <td>First Name</td>
                        <td>Last Name</td>
                        <td>Email</td>
                        <td>Operation</td>
                    </tr>
                    <c:forEach var="faculty" items="${faculties}">               
                        <tr>
                            <td class="tg-hv32">${faculty.firstName}</td>
                            <td class="tg-bsv2">${faculty.lastName}</td>
                            <td class="tg-bsv2">${faculty.email}</td>
                            <td class="tg-bsv2"> <a href="faculty/${faculty.id}">edit</a>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>