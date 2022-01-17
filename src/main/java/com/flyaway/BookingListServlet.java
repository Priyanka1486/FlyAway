package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import com.dbconnection.*;

public class BookingListServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		DBConnection con = new DBConnection();
		List<BookingDetails> bookings = con.getBookingList();
		if(bookings.isEmpty() == false) {
			request.setAttribute("bookings", bookings);
			RequestDispatcher rd = request.getRequestDispatcher("booking");
			rd.forward(request, response);
		}
	}
}


