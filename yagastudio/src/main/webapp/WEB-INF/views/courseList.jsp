<%-- 
    Document   : courseList
    Created on : Oct 15, 2014, 9:28:17 PM
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

                <h1>List of courses</h1>

                <table class="CSSTableGenerator" style="width:70%">
                    <tr><td>Course Name</td><td>Code</td><td>Credit</td><td></td> </tr>

                    <c:forEach var="course" items="${courses}">
                        <tr>                   
                            <td class="tg-hv32">${course.courseName}</td>         
                            <td class="tg-hv32">${course.courseCode}</td>
                            <td class="tg-hv32">${course.courseCredit}</td>

                            <td class="tg-hv32"><a href="course/${course.id}">edit
                                    <form action="course/delete?courseId=${course.id}" metdod="post">
                                        <button type="submit">Delete</button>
                                    </form>  </td>
                        </tr>

                    </c:forEach>
                </table>

                <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
                <label><a href="index.jsp">Cancel</a></label>
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>