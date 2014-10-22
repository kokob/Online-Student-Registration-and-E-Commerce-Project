<%-- 
    Document   : aboutUs
    Created on : Oct 21, 2014, 7:10:14 PM
    Author     : zeriet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="resources/style.css" rel="stylesheet" type="text/css" />
    <title>Yoga Studio</title>

</head>
<div id="container">
    <body>
        <div id="body">
            <jsp:include page="/WEB-INF/views/header.jsp"/> 


            <h1>  Problem Description – Yoga Studio Project  </h1>
            <p>
                We have a growing Yoga Studio with many classes, faculty, customers, and Yoga 
                products. We need an on-line and unified management system that will allow our 
                customers to register for classes, our administrators to create and manage the classes, 
                and our customers to purchase products. 

            <ol><li>Our online class registration system for our Yoga studio should allow customers 
                    to enroll in one or more class for each semester. Each customer has an ID and a 
                    list of previously completed classes at our Yoga studio. When a customer
                    attempts to enroll in a class usually they must have completed the prerequisites 
                    for that class. Our Yoga faculty teach classes and serve as advisors for our 
                    customers. Each customer has a Yoga advisor assigned to them when they attempt 
                    to enroll in their first class. The advisor will be able to waive the prerequisite 
                    requirement for a customer if they think the customer’s request for a waiver is 
                    reasonable. Requests for waivers can be submitted online to the advisor with the 
                    reason for the request. Advisors approve or reject waiver requests online to allow 
                    the customers to continue with their class registration. </li>
                <li> Our administrators should be able to add, delete, and edit Yoga classes. Classes 
                    could have multiple offerings in a semester. Each class has a customer number 
                    limit and is filled on a first come, first serve basis. When the class is filled, 
                    customers may ask to be put on a waiting list for that class.</li>
                <li>We have a catalog of Yoga related products. Our customers should be able to 
                    purchase them on-line. </li> 
            </ol>

            </p>

    </body>
</html>
