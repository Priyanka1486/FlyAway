package com.flyaway;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dbconnection.DBConnection;

import java.io.*;

public class ConfirmationServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DBConnection conn = DBConnection.getDBConnectionInstance();
		if(conn != null) {
			boolean updateflag = false;
			HttpSession session = request.getSession(false);
			if(session != null) {
				String passenger_no= (String)session.getAttribute("passengers");
				int passengers = Integer.parseInt(passenger_no);
				String traveldate = (String)session.getAttribute("traveldate");	
				String flight = (String)session.getAttribute("fid");
				int flight_no = Integer.parseInt(flight);
				int seat= (Integer)session.getAttribute("available_seat");
				System.out.println(passengers);
				System.out.println(flight_no);
				String email = (String)session.getAttribute("email");
				updateflag = conn.checkSeatAvailability(flight_no,traveldate,seat,passengers,email); 
				if(updateflag) {
					int booking_id = conn.getBookingId(traveldate, flight_no, email);
					request.setAttribute("booking_id", booking_id);
					RequestDispatcher rd = request.getRequestDispatcher("confirmationPage");
					rd.forward(request, response);
				}else {
					String msg = "All seats are full in this flight";
					request.setAttribute("msg",msg);
					RequestDispatcher rd = request.getRequestDispatcher("bookingFail");
					rd.forward(request, response);
				}
			}else {
				response.sendRedirect("http://localhost:8080/FlyAway/loginPage");
			}
		} 
	}   
}
