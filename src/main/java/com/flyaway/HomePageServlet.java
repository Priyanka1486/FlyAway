package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HomePageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String travelDate = request.getParameter("traveldate");
		String passengers = request.getParameter("passengers");	
		
		HttpSession session = request.getSession();
		if(session!= null)
		{
			session.setAttribute("source", source);
			session.setAttribute("destination", destination);
			session.setAttribute("traveldate", travelDate);
			session.setAttribute("passengers", passengers);
			RequestDispatcher rd = request.getRequestDispatcher("loginPage");
			rd.forward(request, response);
		}
	}
}
