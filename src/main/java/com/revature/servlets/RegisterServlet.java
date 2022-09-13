package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.UserLogin;
import com.revature.repository.ConnectionFactory;
import com.revature.services.Validation;

public class RegisterServlet extends HttpServlet{
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// Set Response Header
		response.setContentType("text/html");
		
		String dispatch = "";

		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		while (!Validation.isValidUsername(username)) {
			out.println("<font color=red>Please use between 8 and 20 alphanumeric characters</font>");
			
		}
		
		while (!Validation.isValidPass(password)) {
			out.println("<font color=red>Please use between 8 and 20 alphanumeric characters, a special, and a number</font>");
			
		}
		
//		
//		UserLoginDao uDao = new UserLoginDao();
//		
//		String dispatch = "";
//		
//		UserLogin uLog = uDao.getUserLoginByUsername(username);
		
	
			
			UserLogin uLog = new UserLogin(username, password);
			try {
				 ConnectionFactory.getConnection().insert(uLog);
				 uLog =  (UserLogin) ConnectionFactory.getConnection().where(username, "userlogin", "username", UserLogin.class);
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Cookie userName = new Cookie("user", username);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			dispatch = "useraccount.html";
		
		
		
		
		RequestDispatcher rD = request.getRequestDispatcher(dispatch);
		rD.include(request, response);
		
	}

}
