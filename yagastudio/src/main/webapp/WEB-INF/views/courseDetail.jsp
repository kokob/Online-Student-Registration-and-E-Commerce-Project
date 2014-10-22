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
        <link href="../resources/style.css" rel="stylesheet" type="text/css" />
        <title>Yoga Studio</title>

    </head>
     <div id="container">
        <body>
            <div id="body">
                <jsp:include page="/WEB-INF/views/header.jsp"/> 
                <fieldset>
                    <legend>Course Detail:</legend>
                    Course Name: ${currentCourse.courseName}<br>
                    Course Code: ${currentCourse.courseCode}<br>
                    Credit Hours: ${currentCourse.courseCredit}
                    Sections:<br/>

<!--<form action="../enroll/${section.id}" method="POST">-->
                    <!--<form action="../enroll" method="get">-->
                    <ul>
                        <c:forEach var="section" items="${currentCourse.sections}" >
                            <!--<li>-->
                                <!--<input type="radio" name="sectionid" value="${section.id}" />-->
                                <!--Professor ${section.teacher.firstName} ${section.teacher.lastName}<br />-->
                            <!--</li>-->



                            <li>
                                Professor ${section.teacher.firstName} ${section.teacher.lastName}  
                                <a href="../enroll/${section.id}">enroll</a>
                            </li>

                            <!--                                <input type="submit" value="Enroll"/>-->


                        </c:forEach>
                    </ul>

                    <!--<input type="submit" value="Enroll"/>-->

                    <!--</form>-->
                </fieldset>



                
                </form>
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>