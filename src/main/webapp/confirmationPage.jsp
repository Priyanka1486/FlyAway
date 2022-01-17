<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation Page</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/FlyAway/navbar.css" >
</head>
<body>
<ul>
	<li><a>FlyAway</a></li>
	<li><a href="http://localhost:8080/FlyAway/homePage.html">Home</a></li>
  	<li style="float:right"><a href="logout">Logout</a></li>
</ul>
	 <h1>Welcome : <%= session.getAttribute("name") %></h1>
	 <h2>Booking Confirm !!! Your Booking Id is ${requestScope.booking_id}</h2>
	 <h3><a href="http://localhost:8080/FlyAway/homePage.html" >Home</a></h3>
</body>
</html>