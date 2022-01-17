<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking List</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/FlyAway/navbar.css" >
</head>
<body>
	<ul>
		<li><a>FlyAway</a></li>
		<li><a href="http://localhost:8080/FlyAway/homePage.html">Home</a></li>
		<li><a href="routelist">Route List</a></li>
		<li><a href="flightlist">Flight List</a></li>
		
		<li style="float:right"><a>Admin</a></li>
	</ul>
	<h1>Booking List</h1>
	<table>
		<tr>
			<th>Booking Id</th>
			<th>Travel Date</th>
			<th>Flight No</th>
			<th>User Email</th>
			<th>No of Passenger</th>
		</tr>
		<tr></tr>
		<c:forEach var="booking" items="${bookings}">
		<tr>
			<td>${booking.booking_id}</td>
			<td>${booking.traveldate}</td>
			<td>${booking.flight_no}</td>
			<td>${booking.useremail}</td>
			<td>${booking.no_of_passengers}</td>
		</tr>	
		<tr></tr>
		</c:forEach>
	</table>
	
</body>
</html>