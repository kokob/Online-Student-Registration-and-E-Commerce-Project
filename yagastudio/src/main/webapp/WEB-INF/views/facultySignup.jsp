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
        <title>Faculty Signup</title>
    </head>
    <body>

        <fieldset>   
            <form action="addFaculty" method="post">
                <div>
                    <legend>New faculty signup </legend>
                          <label> First Name:  </label><input type="text" name="firstname" /> 
                          <label>Last Name:  </label><input type="text" name="lastname" />                      
                          <label>Gender:  </label><input type="checkbox" name="gender" />                      
                          <label> User Name:  </label><input type="text" name="username" />                     
                          <label> Password:>  </label><input type="password" name="password" />
                          <label> Email:  </label><input type="text" name="email" />
                          <label>  Street:  </label><input type="text" name="street" />
                          <label>  City:    </label><input type="text" name="city" />  
                          <label> State:  </label> <input type="text" name="state" />
                         <label> Zip:   </label><input type="text" name="zip" />
                    <input type="submit" value="Register" />
            </form>
            <label><a href="index.jsp">Cancel</a></label>
        </fieldset>
    </div>     
</body>
</html>
