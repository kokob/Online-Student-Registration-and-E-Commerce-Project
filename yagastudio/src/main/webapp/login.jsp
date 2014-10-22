<%-- 
    Document   : login
    Created on : Oct 16, 2014, 10:28:31 PM
    Author     : kokob
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter" %>
<%@ page import="org.springframework.security.core.AuthenticationException" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>login Page</title>
    </head>
    <div id="container">
        <body>
            <div id="body">
                <jsp:include page="/WEB-INF/views/header.jsp"/> 

                <c:if test="${not empty param.login_error}">
                    <font color="red">
                    Your login attempt was not successful, try again.<br/><br/>
                    Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                    </font>
                </c:if>
                <form name='form' action="j_spring_security_check" method='POST' class = "basic-grey">
                    <table>
                        <tr>
                            <td>User:</td>
                            <td><input type='text' name='j_username'></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type='password' name='j_password' /></td>
                        </tr>
                        <tr>
                            <td><input name="submit" type="submit" value="LogIn" /></td>
                        </tr>
                    </table>
                             <a href="customerSignup"> Customer sign up</a>

                </form>
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>
