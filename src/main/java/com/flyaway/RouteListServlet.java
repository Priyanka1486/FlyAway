package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import com.dbconnection.*;

public class RouteListServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		DBConnection con = new DBConnection();
		List<RouteDetails> routes = con.getRouteList();
		if(routes.isEmpty() == false) {
			request.setAttribute("routes", routes);
			RequestDispatcher rd = request.getRequestDispatcher("routes");
			rd.forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		doGet(request,response);
	}
}
