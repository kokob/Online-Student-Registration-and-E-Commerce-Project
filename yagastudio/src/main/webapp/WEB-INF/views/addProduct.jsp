<%-- 
    Document   : addProduct
    Created on : Oct 14, 2014, 4:06:38 PM
    Author     : zeriet
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>Add Product</title>

    </head>
    <body>
        
    <p>Add Product for mr. ${currentCustomer.lastName}</p>
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
  <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
          <label><a href="index.jsp">Cancel</a></label>
        </fieldset>
    </body>
</html>
