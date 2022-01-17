<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Routes List</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/FlyAway/navbar.css">
<style>
table, th, td {
  	border: 1px solid black;
    border-spacing: 1px;
    padding: 5px;
}
</style>
</head>
<body>
	<ul>
		<li><a>FlyAway</a></li>
		<li><a href="http://localhost:8080/FlyAway/homePage.html">Home</a></li>
		<li><a href="flightlist">Flights List</a></li>
		<li><a href="bookinglist">Booking List</a></li>
		<li style="float:right"><a>Admin</a></li>
	</ul>
	<h1>Route List</h1>
	<a href="addnewroute">Add New Route</a><br /><br />
	<table>
		<tr>
			<th>Route id</th>
			<th>Source</th>
			<th>Destination</th>
		</tr>
		<tr></tr>
		<c:forEach var="route" items="${routes}" >
		<tr>
			<td>${route.route_id}</td>
			<td>${route.source}</td>
			<td>${route.destination}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>