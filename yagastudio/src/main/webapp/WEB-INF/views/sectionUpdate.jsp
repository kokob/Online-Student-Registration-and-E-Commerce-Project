<%-- 
    Document   : sectionUpdate
    Created on : Oct 20, 2014, 3:52:04 PM
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
                <fieldset>
                    <form action="../section/${section.id}" method="post" class = "basic-grey">      
                        <div>              	
                            <legend>Update Section</legend>
                            <label>Seats Available:</label> <input type="text" name="seatsAvailable" value="${section.seatsAvailable}" />


                            <label>Professor 
                                <select name="selectedfaculty">

                                    <c:forEach var="faculty" items="${theFaculties}" >                              
                                        <option value="${faculty.id}"> professor ${faculty.firstName}</option>
                                    </c:forEach>
                                </select>
                            </label>
                            <label><input type="submit" value="update"/> </label>
                        </div>
                    </form> 
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>