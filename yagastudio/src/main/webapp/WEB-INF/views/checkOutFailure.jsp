<%-- 
    Document   : checkOutFailure
    Created on : Oct 21, 2014, 6:34:16 PM
    Author     : kokob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <div id="container">
        <body>
            <div id="body">
                <jsp:include page="/WEB-INF/views/header.jsp"/> 

        <h1>Check Out failed , You don't have an Item in your cart</h1>
        
        <a href="index.jsp">Back to home page</a>
     </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/>
    </div>
</html>
