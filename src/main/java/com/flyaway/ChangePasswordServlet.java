package com.flyaway;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.dbconnection.*;

public class ChangePasswordServlet extends HttpServlet {

	 	public void doPost(HttpServletRequest request, HttpServletResponse response)
	 	throws ServletException, IOException{
	 		System.out.println("In change Password ");
	 		String currentpassword= request.getParameter("current_password");
			String newpassword = request.getParameter("new_password");		
			String confirmnewpassword = request.getParameter("confirm_password");
			if(newpassword.equals(confirmnewpassword)) {
				DBConnection con = new DBConnection();  
				if(con!= null) {
					HttpSession session = request.getSession();
					String email =(String)session.getAttribute("email");
					boolean isadmin = (Boolean)session.getAttribute("isAdmin");
					boolean updateflag = false;
					if(isadmin) {
						System.out.println("Password not updated...");
						updateflag = con.changePassword(email,newpassword);
						if(updateflag) {
							response.sendRedirect("http://localhost:8080/FlyAway/adminlogin.html");
						}else {
							System.out.println("Password not updated");
						}
					}
				}
			}else {
				System.out.println("Confirm Password Mismatch");
			}
	 	}
}
