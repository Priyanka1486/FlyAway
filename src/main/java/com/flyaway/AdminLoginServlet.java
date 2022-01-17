package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

import com.dbconnection.*;

public class AdminLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		String email= request.getParameter("email");
		String password = request.getParameter("password");		
		DBConnection con = new DBConnection();  
		if(con!= null) {
			String name = con.adminLoginCheck(email,password);
			if(name!="" && name != null) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("name", name);
				boolean isAdmin = true;
				session.setAttribute("isAdmin", isAdmin);
				RequestDispatcher rd = request.getRequestDispatcher("admin/details/dashboard");
				rd.forward(request, response);
			}else {
				response.sendRedirect("adminlogin.html");
			}
		}
	}
}
