<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Failed</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/FlyAway/navbar.css" >
</head>
<body>
<ul>
	<li><a>FlyAway</a></li>
	<li><a href="http://localhost:8080/FlyAway/homePage.html">Home</a></li>
  	<li style="float:right"><a href="logout">Logout</a></li>
</ul>
	 <h1>Welcome : <%= session.getAttribute("name") %></h1>
	 <h2>Booking Failed</h2>
	 <h3>${requestScope.msg}</h3>
	 <a href="http://localhost:8080/FlyAway/homePage.html" >Retry</a>
</body>
</html>
