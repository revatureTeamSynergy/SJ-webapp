package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.UserLogin;
import com.revature.repository.HibernateUtil;
import com.revature.repository.UserLoginDao;


public class LoginServlet extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// Set Response Header
		response.setContentType("text/html");
		
	

		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserLoginDao uDao = new UserLoginDao();
		
		String dispatch = "";
		
		UserLogin uLog = uDao.getUserLoginByUsername(username);
		
		if (uLog == null) {
			out.println("<font color=red>Username or Password is incorrect</font>");
		}
		
		
		
		if(uLog.getPassword().equals(password)) {
			
			dispatch = "useraccount.html";
			
			// Session Handling
			
//			HttpSession session = HibernateUtil.getSession();
//			session.setAttribute("user", "admin");
			
			// set max time for session
//			session.setMaxInactiveInterval(30*60);
			
			Cookie userName = new Cookie("user", username);
			Cookie userId = new Cookie("userLoginId", Integer.valueOf(uLog.getUserLoginId()).toString());
			userId.setMaxAge(30*60);
			userName.setMaxAge(30*60);
			response.addCookie(userId);
			response.addCookie(userName);
			response.setIntHeader("userLoginId", uLog.getUserLoginId());
			
			
			
		} 
		
		if(!uLog.getPassword().equals(password)) {
			out.println("<font color=red>Username or Password is incorrect</font>");
			System.out.println("Failed Login");
			dispatch = "login.html";
			
			
		}
		
		
		
		RequestDispatcher rD = request.getRequestDispatcher(dispatch);
		rD.include(request, response);
		
	}
	public static void processError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("error.html").forward(request, response);
	}
	
}
