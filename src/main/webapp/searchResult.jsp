<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/FlyAway/navbar.css" >
<style>
table, th, td {
  	border: 0px solid black;
}
</style>
</head>
<body>
<ul>
	<li><a>FlyAway</a></li>
	<li><a href="http://localhost:8080/FlyAway/homePage.html">Home</a></li>
  	<li style="float:right"><a href="logout">Logout</a></li>
</ul>
  <h1>	Welcome : <%= session.getAttribute("name") %></h1> 
	<form action="user/checkoutPage" method="post"> 
		<table>
			<c:forEach var="flight" items="${flights}" >				
				<tr>
					<td>Flight Number</td>
					<td>:</td>	
					<td>${flight.flight_no}</td>
					<td></td>
				</tr>
				<tr>
					<td>Cost per Person</td>
					<td>:</td>			
					<td>${flight.price}</td>
					<td></td> 					
				</tr>
				<tr>
					<td>Departure Time</td>
					<td>:</td>			
					<td>${flight.departure_time}</td>
					<td></td> 					
				</tr>
				<tr>
					<td>Arrival Time</td>
					<td>:</td>			
					<td>${flight.arrival_time}</td>
					<td></td> 					
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><input type="submit"  name="${flight.flight_no}" value="Book" ></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>