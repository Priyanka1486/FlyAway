<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/FlyAway/navbar.css">
</head>
<body>
	<ul>
		<li><a>FlyAway</a></li>
		<li><a href="homePage.html">Home</a></li>
		<li><a href="admin/details/changePasswordPage">Change Password</a></li>
		<li style="float:right"><a>Admin</a></li>
	</ul>
	<h1>Data :</h1>
	<a href="admin/details/routelist">Routes List</a><br />
 	<a href="admin/details/flightlist">Flights List</a><br />
 	<a href="admin/details/bookinglist">Booking List</a><br />
</body>
</html>