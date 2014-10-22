<%-- 
    Document   : readerSignup
    Created on : Sep 20, 2014, 10:28:57 PM
    Author     : kokob
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                    <form action="addCustomer" method="post" enctype="multipart/form-data">
                        <div>
                         

                            <div class="errorClass">
                                <c:if test="${nonUniqueMessage ne null}" >
                                    <p>${nonUniqueMessage}</p>
                                    <c:set var="nonUniqueMessage" scope="session" value="${null}"/>

                                </c:if>
                            </div>

                            <label>First Name:</label> <input type="text" name="firstname" />                    
                            <label>Last Name:</label> <input type="text" name="lastname" />                       
                            <label>User Name:</label> <input type="text" name="username" />                        
                            <label>Password:</label> <input type="password" name="password" />                        
                            <label>Email:</label> <input type="text" name="email" />                        
                            <label>Street:</label> <input type="text" name="street" />                       
                            <label> City:</label> <input type="text" name="city" />                       
                            <label> State: </label> <input type="text" name="state" />                       
                            <label> Zip:</label> <input type="text" name="zip" />  
                            <label>Image<input type="file" name="file" id="file"></input></label>
                            <label><input type="submit" value="Register" /></label>
                        </div>

                    </form>
                    <label><a href="index.jsp">Cancel</a></label>
                </fieldset>        
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>
