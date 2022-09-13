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
import com.revature.repository.ConnectionFactory;
import com.revature.repository.UserLoginDao;
import com.revature.services.Validation;

public class RegisterServlet extends HttpServlet{
	
		UserLoginDao uDao = new UserLoginDao();
	
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
		
//		
//		String dispatch = "";
//		
//		UserLogin uLog = uDao.getUserLoginByUsername(username);
		
	
		int randomNum = 1 + (int)(Math.random() * 999999);
			UserLogin uLog = new UserLogin(randomNum, username, password);
			try {
				 uDao.addUserLogin(uLog);
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

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	
	String username = request.getParameter("username");

	
	UserLogin uLog = new UserLogin();
	
	
	
	String dispatch = "";
	
	try {
		uLog = uDao.getUserLoginByUsername((username));
		
		
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	out.print("Requested user login info: " + "<br>");
	
	out.print("userloginId " + uLog.getUserloginid() + "<br>");
	out.print("username " + uLog.getUsername() + "<br>");
	out.print("password " + uLog.getPassword() + "<br>");

	dispatch = "useraccount.html";




RequestDispatcher rD = request.getRequestDispatcher(dispatch);
rD.include(request, response);
	
}

protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
	
	String dispatch = "";
	
	UserLogin uLog = new UserLogin();
	PrintWriter out = response.getWriter();
	String userLoginId = request.getParameter("userLoginId");
	String column = request.getParameter("column");
	String value = request.getParameter("value");
	

	try {
		uLog = uDao.updateUserLogin(Integer.valueOf(userLoginId), column, value);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	dispatch = "accountmenu.html";
	
	
	out.println(column + " of " + "customerid: " + userLoginId  + " updated to " + value + "<br>");
	
	dispatch = "useraccount.html";
	
	RequestDispatcher rD = request.getRequestDispatcher(dispatch);
	rD.include(request, response);
	
	
}

protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
	
	String dispatch = "";
	
	UserLogin uLog = new UserLogin();
	PrintWriter out = response.getWriter();
	String userLoginId = request.getParameter("userLoginId");
	
	

	try {
		uLog = uDao.deleteUserLogin(Integer.valueOf(userLoginId));
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	dispatch = "accountmenu.html";
	
	
	out.println("customerid: " + userLoginId  + " deleted");
	
	dispatch = "useraccount.html";
	
	RequestDispatcher rD = request.getRequestDispatcher(dispatch);
	rD.include(request, response);
	
	
}

	

}
