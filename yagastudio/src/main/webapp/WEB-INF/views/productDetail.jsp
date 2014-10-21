<%-- 
    Document   : productDetail
    Created on : Oct 20, 2014, 4:50:02 PM
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
        <title>productDtail Page</title>
    </head>
    <div id="container">
        <body>
            <div id="body">
                <jsp:include page="/WEB-INF/views/header.jsp"/> 

                <h1>Product detail</h1>

                <fieldset>
                    <ul>

                        <li><span> ${currentProduct.productName}</span></li> 

                        <p><img src="productpic/${currentProduct.id}" width="100" height="100"/></p>

                        <li>Price: ${currentProduct.price}</li>

                        <li>Description: ${currentProduct.description}</li>

                    </ul>

                    <form action="../addToCart/${currentProduct.id}"  method="post">
                        <label>Quantity:</label> <input type="number" name="quantity"/>
                        <input type="submit" value="Add to cart"/>
                        <!--<input type="image" src="./resources/cartButton.jpg" alt="Submit Form" />-->
                    </form>

                </fieldset>


            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/>
    </div>
</html>
