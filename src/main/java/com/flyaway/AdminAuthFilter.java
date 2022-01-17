package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AdminAuthFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)
	throws ServletException, IOException{
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession(false);
		if(session != null)
		{   
			System.out.println("In Admin auth filter");
			chain.doFilter(req, response);
		}else {
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect("http://localhost:8080/FlyAway/adminlogin.html");
		}
	}
}
