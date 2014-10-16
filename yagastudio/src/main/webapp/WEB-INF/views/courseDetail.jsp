<%-- 
    Document   : courseDetail
    Created on : Oct 15, 2014, 4:33:32 PM
    Author     : abel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>Course Detail</title>
    </head>
    <body>

        <form action="../courses/${course.id}" method="post">
            <form>
                <fieldset>
                    <legend>Course Detail:</legend>
                    Course Name: ${currentCourse.courseName}<br>
                    Course Code: ${currentCourse.courseCode}<br>
                    Credit Hours: ${currentCourse.courseCredit}
                    Sections:
                    <ul>
                        <c:forEach var="section" items="${currentCourse.sections}" >

                                <li>Professor ${section.teacher.firstName} ${section.teacher.lastName}</li>

                        </c:forEach>
                    </ul>
                </fieldset>



                <p> <a href="registerForCourse">Register</a> &nbsp;
                    <a href="applyForWaiver"> Apply For Waiver</a></p>
            </form>


    </body>
</html>