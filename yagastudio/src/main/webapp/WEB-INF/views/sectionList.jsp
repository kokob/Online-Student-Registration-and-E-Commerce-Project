<%-- 
    Document   : sectionList
    Created on : Oct 17, 2014, 5:31:15 PM
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

        <h1>List of Sections</h1>
        <fieldset>
            <c:forEach var="section" items="${sections}">
                <fieldset>
                    <ul>
                        <li><strong>${section.section.sectionName}</strong></li>              
                        <li>section code: ${section.sectionCode}</li>
                        <li>section credit:${section.sectionCredit}</li>		
                        <a href="section/${section.id}">edit</a>
                        <form action="section/delete?sectionId=${section.id}" method="post">
                            <button type="submit">Delete</button>
                        </form>
                    </ul>
                </fieldset>
            </c:forEach>
        </fieldset>

        <!--	<a href="addCar.html"> Add a Car</a>-->
    </body>
</html>
