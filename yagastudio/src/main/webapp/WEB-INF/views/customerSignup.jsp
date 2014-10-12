<%-- 
    Document   : readerSignup
    Created on : Sep 20, 2014, 10:28:57 PM
    Author     : kokob
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
        <title>Customer Signup</title>
    </head>
    <body>
        
        
      <form action="addCustomer" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstname" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastname" /></td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
                                <td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><input type="text" name="street" /></td>
			</tr>
                        <tr>
				<td>City: </td>
				<td><input type="text" name="city" /></td>
			</tr>
                        <tr>
				<td>State:</td>
				<td><input type="text" name="state" /></td>
			</tr>
                        <tr>
				<td>Zip: </td>
				<td><input type="text" name="zip" /></td>
			</tr>
                        
		</table>
		<input type="submit" value="Register" />

	</form>
            
            
            <p><a href="index.jsp">Cancel</a></p>
            
       </div>     
    </body>
</html>
