<%-- 
    Document   : addToWaitlist
    Created on : Oct 17, 2014, 2:21:35 PM
    Author     : b
--%>

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
                <h3>${section.course.courseCode} by Professor ${section.teacher.lastName} is full.</h3>

                <a href="../addToWaitlist">Add to Waitlist</a><br />

                <a href="../courses/${section.course.id}">Back to Sections</a>

            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>