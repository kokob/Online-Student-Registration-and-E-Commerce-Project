<%-- 
    Document   : viewWaivers
    Created on : Oct 19, 2014, 10:02:47 PM
    Author     : b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your waivers are:</h1>
        <c:if test="${pendingWaivers.isEmpty()}" >
            <p>
                You don't have any waiver requests!
            </p>
        </c:if>
        <c:forEach var="waiver" items="${pendingWaivers}" >
            <div>
                <label>Student Name: </label>${waiver.customer.firstName} ${waiver.customer.lastName}
                <label>Course Name: </label>${waiver.course.courseName} (${waiver.course.courseCode})
                <label>Reason: </label>${waiver.reason}<br/>
                
                <form action="approveWaiver/${waiver.id}" method="post">
                    <input type="radio" name="waiverStatus" value="yes" />Approve
                    <input type="radio" name="waiverStatus" value="no" />Reject
                    <input type="submit" value="Apply" />
                </form>
                
            </div>
            
        </c:forEach>
    </body>
</html>
