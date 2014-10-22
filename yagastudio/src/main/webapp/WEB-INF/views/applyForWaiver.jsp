<%-- 
    Document   : reasonWaiver
    Created on : Oct 15, 2014, 11:19:46 PM
    Author     : abel
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
                <legend>Reason for Waiver Request</legend>
                <form action="applyForWaiver" method="post">


                    <label>Course: </label>${currentCourse.courseName}
                    <br/>
                    <label>Reason: </label>
                    <br/>
                    <textarea name="reason" rows="5" cols="50"></textarea>
                    <br/>
                    <label><input type="submit" value="Submit"/></label> 

                </form>

                <a href="<c:url value="j_spring_security_logout" />" > Logout</a>

                </fieldset>    
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>