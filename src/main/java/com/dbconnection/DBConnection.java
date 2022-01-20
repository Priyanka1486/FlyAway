package com.dbconnection;
  
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.flyaway.*;
import java.io.*;

public class DBConnection {
	private final String URL = "jdbc:mysql://localhost:3306/flyawaydb";
	private final String USER = "root";
	private final String PASSWORD = "Test@123";
	public Connection connection = null;
	private static DBConnection dbcon = null;
	
	private DBConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection Established");
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("DB Error");
		}				
	}
	
	// Get DB Connection 
	public static DBConnection getDBConnectionInstance() {
		if(dbcon == null) {
			dbcon = new DBConnection();
		}
		return dbcon;
	}
	
	//Insert into Table
	public boolean userRegistration(UserDetail user) {
		boolean flag = false;
		if(connection != null) {
			try {
				PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?)");
				ps.setString(1,user.getEmail());
				ps.setString(2,user.getPassword());
				ps.setString(3,user.getFirstName());
				ps.setString(4,user.getLastName());
				System.out.println("In statement");
				int row_added = ps.executeUpdate();
				System.out.println("In update");
				if(row_added > 0) {
					System.out.println("New record inserted!");
					flag = true;
				}else if(row_added == 0) {
					System.out.println("No new record inserted!");
				}
			}catch(SQLException e) {
				System.out.println("Problem in Data insertion");
				return false;
			}
		}
		return flag;
	}
	
	// User Login Check
	 public UserDetail userLoginCheck(String email,String password){
		UserDetail user = null;
		if(connection != null) {
			try {
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE email=? and password=?");
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					user = new UserDetail();
					System.out.println("User Found!!");				
					user.setFirstName(rs.getString("firstname"));
					System.out.println();
				}else {
					System.out.println("User Not Found!!");
				}
			}catch(SQLException e) {
				System.out.println("Problem in User's Login Check");
				return user;
			}
		}
		return user;
	}
	
	//getSeat
	/* public int getSeatForThisFlight(String flight_no,String travelDate) {
		 int seat=0;
		 if(connection!= null) {
			 try {
				 String query= "Select available_seat from booking where flight_no=? and traveldate=?";
				 PreparedStatement ps = connection.prepareStatement(query);
				 ps.setString(1, flight_no);
				 ps.setString(2, travelDate);
				 ResultSet rs = ps.executeQuery();
				 if(rs.next())
					 seat = rs.getInt("available_seat");
			 }catch(SQLException e) {
				 System.out.println("Problem in getting available seat in flight");
			 }
		 }
		 return seat;
	 }
	 
	 // Get Route_id and Flight_no from DB
	 public List<FlightDetails> getAvailableFlights(String source,String destination, String travelDate) {
		List <FlightDetails> flights = new ArrayList();
		 if(connection != null) {
			 try {
				 String query = "select * from flights where flights.flight_no in (select booking.flight_no from booking where booking.traveldate=? and booking.available_seat>0 and booking.flight_no in (select flight_route.flight_no from flight_route where flight_route.route_id=(select routes.route_id from routes where routes.source=? and routes.destination=?)))";
				 PreparedStatement ps = connection.prepareStatement(query);
				 ps.setString(1, travelDate);
				 ps.setString(2, source);
				 ps.setString(3, destination);
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()) {
					FlightDetails flight = new FlightDetails();
					
					flight.setFlight_no(rs.getInt("flight_no"));
					int seat = getSeatForThisFlight(rs.getString("flight_no"),travelDate);
					flight.setAvailable_seat(seat);
					flight.setPrice(rs.getDouble("price"));
					flight.setDeparture_time(rs.getTime("departure_time"));
					flight.setArrival_time(rs.getTime("arrival_time"));
					flights.add(flight);
				 }
			 }catch(SQLException e) {
				 System.out.println("Problem in fetching data");
				 return flights;
			 }			  
		 }
		 return flights;
	 }	 
	 
	//Booking Table Update
	 public boolean availableSeatUpdate(int seat,String flight_no, String traveldate) {
		 boolean updateflag= false;
		 if(connection!= null) {
			 try {
				
				String query = "update booking set available_seat =? where traveldate = ? and flight_no = ?";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, seat);
				ps.setString(2, traveldate);
				ps.setString(3, flight_no);			
				int row_affected = ps.executeUpdate();
				if(row_affected>0) 
					updateflag=true;				
			 }catch(SQLException e) {
				 System.out.println("Problem in Updating booking table");
				 return updateflag;
			 }
		 }
		 return updateflag;
	 }
	 */
	
	 //Insert into booking table
	 public boolean updateBookingTable(String traveldate,int flight_no,int passengers,String email) {
		 boolean updateflag = false;
		 if(this.connection!= null){
			 try {
				 String query = "INSERT INTO booking(traveldate,flight_no,email,no_of_passengers) VALUES(?,?,?,?)";
				 PreparedStatement ps = this.connection.prepareStatement(query);
				 ps.setString(1, traveldate);
				 ps.setInt(2, flight_no);
				 ps.setString(3, email);
				 ps.setInt(4, passengers);
				 int row_added = ps.executeUpdate();
				 if(row_added>0) {
					 updateflag = true;
				 }
			 }catch(SQLException e) {
				 System.out.println("Problem in updating booking table");
				 return updateflag;
			 }
		 }
		 return updateflag;
	 }
	// getBooking id
	 public int getBookingId(String traveldate,int flight_no,String email) {
		 int id=0;
		 if(this.connection != null) {
			 try {
				 String query = "SELECT booking_id FROM booking WHERE traveldate=? and flight_no=? and email=?";
				 PreparedStatement ps = this.connection.prepareStatement(query);
				 ps.setString(1, traveldate);
				 ps.setInt(2, flight_no);
				 ps.setString(3, email);
				 ResultSet rs =ps.executeQuery();
				 if(rs.next()) {
					 id = rs.getInt("booking_id");
				 }
			 }catch(SQLException e) {
				 System.out.println("Problem in getting Booikng id ");
				 return id;
			 }
		 }
		 return id;
	 }
	// Seat availability in flight
	 public boolean checkSeatAvailability(int flight_no,String traveldate,int seat,int passengers,String email) {
		 boolean flag = false;
		 if(this.connection != null) {
			 try {
			//	 String query = "SELECT SUM(no_of_passengers) FROM booking WHERE traveldate='"+traveldate+"' and flight_no ="+flight_no;
			//	 Statement stm = this.connection.createStatement();
			//	 ResultSet rs = stm.executeQuery(query);
				 String query = "SELECT SUM(no_of_passengers) FROM booking WHERE traveldate=? and flight_no=?";
				 PreparedStatement ps = this.connection.prepareStatement(query);
				 ps.setString(1, traveldate);
				 ps.setInt(2, flight_no);
				 ResultSet rs =ps.executeQuery();
				 int total_passengers;
				 if(rs.next()) {
					 String num = rs.getString(1);
					 if(num != null) {
						 total_passengers = Integer.parseInt(num);
						 if((total_passengers + passengers) <= seat) {
							 flag = updateBookingTable(traveldate,flight_no,passengers,email);
						 }else {
							 System.out.println("booking fail no seat available");
						 }
					 }else {
						 flag = updateBookingTable(traveldate,flight_no,passengers,email);
					 }
				 }
			 }catch(SQLException e) {
				 System.out.println("Problem in seat availability check");
				 return flag;
			 }
		 }
		 return flag;
	 }
	 
	// Flight search for travel
	 public List<FlightDetails> flightSearch(String source,String destination) {
		 List flights = new ArrayList();
		 if(this.connection!= null) {
			 try {
			/*  
				 String query = "SELECT * FROM flights WHERE flights.route_id=(SELECT routes.route_id FROM routes WHERE routes.source='"+source+"' and routes.destination='"+destination+"')";
				 Statement stm = this.connection.createStatement();
				 ResultSet rs = stm.executeQuery(query);
			 */
			 	 String query = "SELECT * FROM flights WHERE flights.route_id=(SELECT routes.route_id FROM routes WHERE routes.source=? and routes.destination=?)";
				 PreparedStatement ps = this.connection.prepareStatement(query);
				 ps.setString(1, source);
				 ps.setString(2, destination);
				 System.out.println( "In db source is:"+source);
				 System.out.println("In db destination is: "+destination);
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()) {
					FlightDetails flight = new FlightDetails();
					flight.setFlight_no(rs.getInt("flight_no"));
					flight.setPrice(rs.getDouble("price"));
					flight.setArrival_time(rs.getTime("arrival_time"));
					flight.setDeparture_time(rs.getTime("departure_time"));
					flight.setAvailable_seat(rs.getInt("available_seat"));
					flights.add(flight);
				 }  
			 }catch(SQLException e) {
				 System.out.println("Problem in flight search");
				 return flights;
			 }
		 }
		 return flights;		 
	 }
	 //Admin login check
	 public String adminLoginCheck(String email, String password) {
		 String name = "";
		 if(this.connection!=null) {
			 try {
				String query="SELECT firstname FROM admin where email=? and password=?";
				PreparedStatement ps= this.connection.prepareStatement(query);
				ps.setString(1, email);
				ps.setString(2, password);				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					name = rs.getString("firstname");
				}				
			 }catch(SQLException e) {
				 System.out.println("Problem in Admin Login");
				 return name;
			 }
		 }
		 return name;
	 }
	 
	 // Admin Password Change
	 public boolean changePassword(String email, String newPassword) {
		 boolean passwordUpdateflag = false;
		 if(this.connection!= null) {
			 try {
				 String query="update admin set password=? where email=?";
				 PreparedStatement ps= this.connection.prepareStatement(query);	
				 ps.setString(1, newPassword);
				 ps.setString(2, email);
				 int row_affected = ps.executeUpdate();
				 if (row_affected > 0)
					 passwordUpdateflag = true ;
				 else
					 System.out.println("Password Not Updated");
			 }catch(SQLException e) {
				 System.out.println("Problem in updating Password");
				 return passwordUpdateflag;
			 }
		 }
		 return passwordUpdateflag;
	 }
	 
	 // Admin get RouteList
	 public List<RouteDetails> getRouteList(){
		 List <RouteDetails>routes = new ArrayList<RouteDetails>();
		 if(this.connection!= null) {
			 try {
				 String query = "SELECT * FROM routes";
				 PreparedStatement ps = this.connection.prepareStatement(query);
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()) {
					 RouteDetails route = new RouteDetails();
					 route.setRoute_id(rs.getInt("route_id"));
					 route.setSource(rs.getString("source"));
					 route.setDestination(rs.getString("destination"));
					 routes.add(route);
				 }
			 }catch(SQLException e) {
				 System.out.println("Problem in fetching route list");
				 return routes;
			 }
		 }
		 return routes;
	 }
	 
	 // Admin get flight list
	 public List<FlightDetails> getFlightList(){
		List<FlightDetails> flights = new ArrayList<FlightDetails>();
		if(this.connection!= null) {
			try {
				String query = "SELECT * FROM flights";
				PreparedStatement ps= this.connection.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					FlightDetails flight = new FlightDetails();
					flight.setPrice(rs.getDouble("price"));
					flight.setAvailable_seat(rs.getInt("available_seat"));
					flight.setDeparture_time(rs.getTime("departure_time"));
					flight.setArrival_time(rs.getTime("arrival_time"));
					flight.setFlight_no(rs.getInt("flight_no"));
					flight.setRoute_id(rs.getInt("route_id"));
					flights.add(flight);
				}
			}catch(SQLException e) {
				System.out.println("Problem in fetching flight List");
				return  flights;
			}
		}
		return flights;
	 }
	 
	 //Admin get Booking List
	 public List<BookingDetails> getBookingList(){
		List<BookingDetails> bookings = new ArrayList<BookingDetails>();
		if(this.connection!= null) {
			try {
				String query = "SELECT * FROM booking";
				PreparedStatement ps= this.connection.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					BookingDetails booking = new BookingDetails();
					booking.setBooking_id(rs.getInt("booking_id"));
					booking.setTraveldate(rs.getString("traveldate"));
					booking.setFlight_no(rs.getInt("flight_no"));
					booking.setUseremail(rs.getString("email"));
					booking.setNo_of_passengers(rs.getInt("no_of_passengers"));
					bookings.add(booking);
				}
			}catch(SQLException e) {
				System.out.println("Problem in fetching booking List");
				return  bookings;
			}
		}
		 return bookings;
	 }
	 
	 //Admin add route in database
	 public boolean addRoute(RouteDetails route) {
		 boolean addflag= false;
		 if(this.connection!= null) {
			 try {
				 String query="INSERT INTO routes(source,destination) VALUES (?,?)";
				 PreparedStatement ps = this.connection.prepareStatement(query);
				 ps.setString(1, route.getSource());
				 ps.setString(2, route.getDestination());
				 int row_added = ps.executeUpdate();
				 if(row_added>0) {
					 System.out.println("Route added");
					 addflag=true;
				 }
				 else if(row_added == 0) {
					 System.out.println("Route not added");
				 }
			 }catch(SQLException e) {
				 System.out.println("Problem in adding Route");
				 return addflag;
			 }
		 }
		 return addflag;
	 }
 	 
	// Admin add new flight in database 
	public boolean addFlight(FlightDetails flight){
		boolean addflag =false;
		if(this.connection!= null) {
			try {
				String query="INSERT INTO flights(price,available_seat,departure_time,arrival_time,route_id) VALUES(?,?,?,?,?)";
				PreparedStatement ps= this.connection.prepareStatement(query);
				ps.setDouble(1,flight.getPrice());
				ps.setInt(2, flight.getAvailable_seat());
				ps.setTime(3, flight.getDeparture_time());
				ps.setTime(4, flight.getArrival_time());
				ps.setInt(5, flight.getRoute_id());
				
				int row_added = ps.executeUpdate();
				if(row_added > 0) {
					addflag = true;
				}
				else {
					System.out.println("Flight not added");
				}
				
			}catch(SQLException e) {
				System.out.println("Problem in adding new flight");
				return addflag;
			}
		}
		return addflag;
	}
	
	// DB Connection close	
	public void closeConnection() {
		try {
			this.connection.close();
		}catch(SQLException e){
			System.out.println("Problem in closing Connection");
		}
	}
}
