<%-- 
    Document   : productUpdate
    Created on : Oct 20, 2014, 11:14:57 AM
    Author     : zeriet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="../resources/style.css" rel="stylesheet" type="text/css" />
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
	 <form action="../product/${product.id}" method="post" class = "basic-grey"> 
	<div>
                    <table>
                        <tr>
                            <!--<legend>New product</legend>-->
                            <td>Product Name:</td>
                            <td> <input name="productName" type ="text" value=${product.productName}></td>
                        </tr> 
                        <tr>
                            <td>Price:</td> <td><input name="price" type ="text"value=${product.price}></td>
                        </tr> 
                       
                        <tr>
                            <!--<td>Description:</td> <td><textarea name="description:"cols="30" rows="4"></textarea></td>-->
                          
                            <td>Description:<textarea name="description" cols="30" rows="4"> ${product.description}</textarea>
                        </tr> 
                        <tr>
<!--                        <tr>
                            <td>Image</td> <td><input type="file" name="file" id="file"></input></td>
                            </tr>-->
                            <tr>
<!--                                <td>
                                    <input type="submit" value="Add Image"/>
                                </td>-->
                            </tr>
                            <td><input type="submit" value="update Product" /></td>
                            </tr>
                        </table>

                    </div>
	</c:forEach>
	</fieldset>
    
            </div>
        </body>
        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
    </div>
</html>