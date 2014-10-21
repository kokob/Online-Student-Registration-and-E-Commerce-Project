<%-- 
    Document   : facultiesList
    Created on : Oct 17, 2014, 5:43:02 PM
    Author     : zeriet
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>

        <h1>List of faculties</h1>
      
        <table class="tg" style="width:70%">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Operation</th>
            </tr>
            <c:forEach var="faculty" items="${faculties}">               
                <tr>
                    <th class="tg-hv32">${faculty.firstName}</th>
                    <th class="tg-bsv2">${faculty.lastName}</th>
                    <th class="tg-bsv2">${faculty.email}</th>
                    <th class="tg-bsv2"> <a href="faculty/${faculty.id}">edit</a>
                <form action="faculty/delete?facultyId=${faculty.id}" method="post">
                    <button type="submit">Delete</button>
                </form></th>
        </tr>
    </c:forEach>
</t
    </body>
</html>
