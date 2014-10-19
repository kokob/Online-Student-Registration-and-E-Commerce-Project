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
        <div class="error">

           <c:if test="${not errorMessage eq null}">
                
                    <p> ${errorMessage}</p>
             
            </c:if> 
        </div>

        <p>Add Product for mr. ${currentCustomer.lastName}</p>
        <fieldset>
            <form:form action="addProduct" method="post" enctype="multipart/form-data">
                <div>
                    <table>
                        <tr>
                            <!--<legend>New product</legend>-->
                            <td>Product Name:</td>
                            <td> <input name="productName" type ="text"/></td>
                        </tr> 
                        <tr>
                            <td>Unit Price:</td> <td><input name="price" type ="text"/></td>
                        </tr> 
                        <tr>
                            <td>Quantity:</td> <td><input name="quantity:" type ="text"/></td>
                        </tr>
                        <tr>
                            <!--<td>Description:</td> <td><textarea name="description:"cols="30" rows="4"></textarea></td>-->
                            <td>Description: </td> <td><input name="description:" type ="text"/></td>
                        </tr> 
                        <tr>
                        <tr>
                            <td>Image</td> <td><input type="file" name="file" id="file"></input></td>
                            </tr>
                            <tr>
<!--                                <td>
                                    <input type="submit" value="Add Image"/>
                                </td>-->
                            </tr>
                            <td><input type="submit" value="Add Product" /></td>
                            </tr>
                        </table>

                    </div>
                </for  </form:form>
                <a href="<c:url value="j_spring_security_logout" />" > Logout</a>
            <td><a href="index.jsp">Cancel</a></td>
        </fieldset>
    </body>
</html>
