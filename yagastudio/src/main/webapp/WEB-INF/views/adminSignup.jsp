<%-- 
    Document   : adminSignup
    Created on : Oct 19, 2014, 10:48:52 AM
    Author     : kokob
--%>

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
                <form action="addAdmin" method="post">
                    <div>
                        <legend>New Admin signup</legend>           
                        <label>First Name:</label> <input type="text" name="firstname" />                    
                        <label>Last Name:</label> <input type="text" name="lastname" />
                        <label>Email:</label> <input type="text" name="email" />
                        <label>User Name:</label> <input type="text" name="username" />                        
                        <label>Password:</label> <input type="password" name="password" />                        

                        <label><input type="submit" value="Register" /></label>
                    </div>

                </form>
                <label><a href="index.jsp">Cancel</a><label>
                        </fieldset>    

                        </div>
                        </body>
                        <jsp:include page="/WEB-INF/views/footer.jsp"/> 
                        </div>
                        </html>