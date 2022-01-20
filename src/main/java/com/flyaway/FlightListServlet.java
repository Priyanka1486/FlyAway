package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import com.dbconnection.*;

public class FlightListServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		DBConnection con = DBConnection.getDBConnectionInstance();
		List<FlightDetails> flights = con.getFlightList();
		if(flights.isEmpty() == false) {
			request.setAttribute("flights", flights);
			RequestDispatcher rd = request.getRequestDispatcher("flights");
			rd.forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		doGet(request,response);
	}
}
