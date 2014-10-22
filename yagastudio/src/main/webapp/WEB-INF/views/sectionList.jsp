<%-- 
    Document   : sectionList
    Created on : Oct 17, 2014, 5:31:15 PM
    Author     : zeriet
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

                <h2>List of Sections</h2>

                <table class="CSSTableGenerator" style="width:70%">
                    <tr>
                        <td>Section Id</td>
                        <td>Course</td>
                        <td>Instructor</td>
                        <td>Seats Available</td>
                        <td></td>
                    </tr>
                    <c:forEach var="section" items="${sections}">

                        <tr>
                            <td class="tg-hv32">${section.id}</td> 
                            <td class="tg-hv32">${section.course.courseName}</td>
                            <td class="tg-hv32">Professor ${section.teacher.firstName}&nbsp ${section.teacher.lastName}</td> 
                            <td class="tg-hv32">${section.seatsAvailable}</td>

                            <td class="tg-hv32"> <a href="section/${section.id}">edit</a>
                                <form action="section/delete?sectionId=${section.id}" method="post">
                                    <button type="submit">Delete</button>
                                </form></td>
                        </tr>
                    </c:forEach>
                </table 
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>