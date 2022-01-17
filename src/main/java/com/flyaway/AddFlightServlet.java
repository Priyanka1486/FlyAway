package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.dbconnection.*;
import java.sql.Time;

public class AddFlightServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		
		double price = Integer.parseInt(request.getParameter("price"));
		int available_seat = Integer.parseInt(request.getParameter("available_seat"));
		Time arrival_time= Time.valueOf(request.getParameter("arrival_time"));
		Time departure_time =Time.valueOf(request.getParameter("departure_time"));
		int route_id = Integer.parseInt(request.getParameter("route"));
		DBConnection con = new DBConnection();
		
		if(con!= null) {
			FlightDetails flight = new FlightDetails(price,departure_time,arrival_time,available_seat,route_id);
			boolean addflag= false;
			addflag = con.addFlight(flight);
			if(addflag) {
				RequestDispatcher rd = request.getRequestDispatcher("flightlist");
				rd.forward(request, response);				
			}
			else {
				System.out.println("Adding Flight Fail");
				response.sendRedirect("adminlogin.html");
			}
		}
	}
}
