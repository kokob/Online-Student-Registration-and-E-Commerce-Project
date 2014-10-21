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
        <title>Yoga Studio</title>

    </head>
    <div id="container">
        <body>
            <div id="body">
                <jsp:include page="/WEB-INF/views/header.jsp"/> 
       
	<h2>Products available currently in the store</h2>
	<fieldset>
	<c:forEach var="myproduct" items="${products}">
	<fieldset>
            <ul>
		<li> ${myproduct.productName}</li>             
                <p><img src="productpic/${myproduct.id}" width="100" height="100"/></p>
		<li>Price: ${myproduct.price}</li>
		<li style="width:150px">Description: ${myproduct.description}</li>		
		<a href="product/${myproduct.id}">edit</a>
                 <form action="product/delete?productId=${myproduct.id}" method="post">
                            <button type="submit">Delete</button>
                        </form>
                  </ul>
	</fieldset>
	</c:forEach>
	</fieldset>	
	
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>