package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.dbconnection.*;

public class AddRouteServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		DBConnection con = new DBConnection();
		if(con!= null){
			RouteDetails route = new RouteDetails(source,destination);
			System.out.println(route);
			boolean flag = con.addRoute(route);
			if(flag) {
				RequestDispatcher rd = request.getRequestDispatcher("routelist");
				rd.forward(request, response);
			}else {
				System.out.println("Route not added");
				response.sendRedirect("http://localhost:8080/FlyAway/adminlogin.html");
			}
		}
	}  
}
