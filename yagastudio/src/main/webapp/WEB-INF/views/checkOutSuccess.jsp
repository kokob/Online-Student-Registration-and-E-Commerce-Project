<%-- 
    Document   : checkOutSuccess
    Created on : Oct 21, 2014, 6:31:31 PM
    Author     : kokob
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../resources/style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
<div id="container">
        <body>
            <div id="body">
                <jsp:include page="/WEB-INF/views/header.jsp"/> 
        <h1>Hello World! success</h1>
        
        <P>${currentOrder.date}</p><br />
        
        <p>${currentOrder.customer.firstName}</p><br />
        
        <p>${currentOrderPrice}</p><br />
        
                        <table class="tg" style="width:70%">
                    <tr>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>

                    <c:forEach var="currentOrderLine" items="${currentOrderLines}">
                        <tr>


                            <th class="tg-hv32"> ${currentOrderLine.product.productName}</th> 
                            <th class="tg-bsv2"> ${currentOrderLine.product.price}</th>
                            <th class="tg-bsv2"> ${currentOrderLine.quantity}</th>


                        </tr>
                    </c:forEach>

                    <tr>
                        <th>Total Price</th>
                        <th>${currentShoppingCartPrice}</th>
                        <th></th>                            
                    </tr>

                </table>
                        <a href="index.jsp">Back To Home Page</a>
         </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/>
    </div>
</html>
