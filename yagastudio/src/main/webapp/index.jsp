<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
        
           
                <p> <a href="customerSignup"> Customer sign up</a></p>
                <p> <a href="facultySignup"> Faculty sign up</a></p>              
                <p> <a href="products"> List of products</a></p>
                <p> <a href="viewCourses"> View all Courses</a></p>
                <p> <a href="courses"> List of courses</a></p>
                <p> <a href="sections"> List of sections</a></p> 
                <p> <a href="faculties"> List of faculties</a></p> 
                <p> <a href="customers"> List of customers</a></p>                
                <p> <a href="addProduct"> Add a Product</a></p>
                <p> <a href="addCourse"> Add a Course</a></p>
                <p> <a href="createSection"> Add a Section</a></p>

               
            </div>
    </body>
     <jsp:include page="/WEB-INF/views/footer.jsp"/> 
</div>
</html>
