<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight List</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/FlyAway/navbar.css">
</head>
<body>
	<ul>
		<li><a>FlyAway</a></li>
		<li><a href="http://localhost:8080/FlyAway/homePage.html">Home</a></li>
		<li><a href="routelist">Route List</a></li>
		<li><a href="bookinglist">Booking List</a></li>				
		<li style="float:right"><a>Admin</a></li>
	</ul>
	<h1>Flight List</h1>
	<a href="addnewflight">Add New Flight</a><br /><br />	
	<table>
		<tr>
			<th>Flight No</th>
			<th>Price</th>
			<th>Departure Time</th>
			<th>Arrival Time</th>
			<th>Available Seat</th>
			<th>Route Id</th>
		</tr>
		<tr></tr>
		<c:forEach var="flight" items="${flights}">
		<tr>
			<td>${flight.flight_no}</td>
			<td>${flight.price}</td>
			<td>${flight.departure_time}</td>
			<td>${flight.arrival_time}</td>
			<td>${flight.available_seat}</td>
			<td>${flight.route_id}</td>
		</tr>	
		<tr></tr>
		</c:forEach>
	</table>
</body>
</html>