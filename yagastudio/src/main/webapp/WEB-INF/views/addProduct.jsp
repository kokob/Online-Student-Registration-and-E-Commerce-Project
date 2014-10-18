<%-- 
    Document   : addProduct
    Created on : Oct 14, 2014, 4:06:38 PM
    Author     : zeriet
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>Add Product</title>

    </head>
    <body>
        
        <fieldset>
            <form action="addProduct" method="post">
                <div>
                    <legend>New product</legend>
                    <label>Product Name:</label> <input name="productName" type ="text"/>
                    <label>Price:</label> <input name="price" type ="text"/>
                    <label>Description:</label> <input name="description" type ="text"/>
                    <label><input type="submit" value="Add Product" /></label>
                </div>
            </form>
          <label><a href="index.jsp">Cancel</a></label>
        </fieldset>
    </body>
</html>
