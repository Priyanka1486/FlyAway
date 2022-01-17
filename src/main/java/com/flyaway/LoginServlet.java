package com.flyaway;

import com.dbconnection.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

public class LoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDetail user = null;
		DBConnection conn = new DBConnection();
		if(conn != null) {
			user = conn.userLoginCheck(email,password);
			if(user != null) {
				HttpSession session = request.getSession();
				if(session!=null) {
					session.setAttribute("name", user.getFirstName());
					session.setAttribute("email", email);
					//new test
					List flights = null;
					String source = (String)session.getAttribute("source");				
					String destination =  (String)session.getAttribute("destination");
					flights = conn.flightSearch(source,destination);
					if(flights != null && flights.isEmpty()== false) {
						session.setAttribute("flights", flights);
						RequestDispatcher rd = request.getRequestDispatcher("user/searchResultPage");
						rd.forward(request, response);
					}else {
						String msg = "No Flight are available for this Route";
						request.setAttribute("msg",msg);
						RequestDispatcher rd = request.getRequestDispatcher("user/bookingFail");
						rd.forward(request, response);
					}
				}else {
				response.sendRedirect("loginPage");
			}				
		}else {
			response.sendRedirect("loginPage");
		}
	}
}
}
