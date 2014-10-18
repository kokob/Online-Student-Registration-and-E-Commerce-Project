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
        <fieldset>
            <c:forEach var="faculty" items="${faculties}">
                <fieldset>
                    <ul>
                      
                        <li>First Name${faculty.firstName}</strong></li>              
                        <li>Last Name: ${faculty.lastName}</li>
                        <li>Email:${faculty.email}</li>
                        
                        <a href="faculty/${faculty.id}">edit</a>
                        <form action="faculty/delete?facultyId=${faculty.id}" method="post">
                            <button type="submit">Delete</button>
                        </form>
                    </ul>
                </fieldset>
            </c:forEach>
        </fieldset>
    </body>
</html>
