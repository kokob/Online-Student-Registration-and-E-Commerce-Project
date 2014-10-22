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
        <title>Yoga Studio</title>

    </head>
    <div id="container">
        <body>
            <div id="body">
                <jsp:include page="/WEB-INF/views/header.jsp"/> 
                
               
                <fieldset>
                    <form:form action="addProduct" method="post" enctype="multipart/form-data" class = "basic-grey">
                        <div>
                            <table>
                                <tr>
                                    <!--<legend>New product</legend>-->
                                    <td>Product Name:</td>
                                    <td> <input name="productName" type ="text"/></td>
                                </tr> 
                                <tr>
                                    <td>Price:</td> <td><input name="price" type ="text"/></td>
                                </tr> 
                             
                                <tr>
                                    <td>Description:<td><p><textarea name="description" cols="25" rows="4"></textarea></td>
                                </tr> 
                                <tr>
                                <tr>
                                    <td>Image</td> <td><input type="file" name="file" id="file"></input></td>
                                    <!--                            </tr>-->
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
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>