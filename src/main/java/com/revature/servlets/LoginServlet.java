package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Customer;
import com.revature.models.UserLogin;
import com.revature.repository.CustomerDao;
import com.revature.repository.UserLoginDao;


public class LoginServlet extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// Set Response Header
		response.setContentType("text/html");
		
	

		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
//		
		UserLoginDao uDao = new UserLoginDao();
//		
		String dispatch = "";
//		
		UserLogin uLog = null;
		try {
			uLog = uDao.getUserLoginByUsername(username);
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | InvocationTargetException
				| NoSuchMethodException | SecurityException | NoSuchFieldException | SQLException | NullPointerException e) {
			out.println("<font color=red>Username or Password is incorrect</font>");
			e.printStackTrace();
		}
		
		
		
		if (uLog == null) {
			out.println("<font color=red>Username or Password is incorrect</font>");
		}
		
		
		
		if(uLog.getPassword().equals(password)) {
			CustomerDao cDao = new CustomerDao();
			Customer cust = null;
			try {
				cust = cDao.getCustomerByUserLoginId(uLog.getUserloginid());
			} catch (IllegalArgumentException | IllegalAccessException | InstantiationException
					| InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException
					| SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (cust != null) {
				Cookie customerId = new Cookie("customerId", cust.getCustomerId().toString());
				customerId.setMaxAge(30 * 60);
				response.addCookie(customerId);
			}
			
			dispatch = "useraccount.html";
			
			Cookie userName = new Cookie("user", username);
			Cookie userId = new Cookie("userLoginId", Integer.valueOf(uLog.getUserloginid()).toString());
			userId.setMaxAge(30*60);
			userName.setMaxAge(30*60);
			response.addCookie(userId);
			response.addCookie(userName);
			response.setIntHeader("userLoginId", uLog.getUserloginid());
			
			
			
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
