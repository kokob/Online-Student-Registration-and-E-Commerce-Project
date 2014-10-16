<%-- 
    Document   : productList
    Created on : Oct 15, 2014, 4:39:01 PM
    Author     : zeriet
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
       
	<h1>Products available currently in the store</h1>
	<fieldset>
	<c:forEach var="myproduct" items="${products}">
	<fieldset>
            <ul>
		<li>Product name: ${myproduct.productName}</li>
		<li>Price: ${myproduct.price}</li>
		<li>Description${myproduct.description}</li>		
		<a href="cars/${car.id}">edit</a>
                  </ul>
	</fieldset>
	</c:forEach>
	</fieldset>	
	<a href="addCar.html"> Add a Car</a>
    </body>
</html>
