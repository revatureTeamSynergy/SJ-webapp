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

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.UserLogin;
import com.revature.repository.ConnectionFactory;
import com.revature.repository.CustomerDao;

public class UserAccount extends HttpServlet{
	
	CustomerDao cDao = new CustomerDao();

	
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		
//		response.setContentType("text/html");
//		
//		String dispatch = "";
//		
//
//		PrintWriter out = response.getWriter();
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String userLoginId = request.getParameter("userLoginId");
//		
//		Cookie[] s = request.getCookies();
//		for(int i=0;i<s.length;i++){  
//			 if (s[i].getName().equals("userLoginId")) {
//				 userLoginId = s[i].getValue();
//			 }
//			}  
//		
//		
//		int randomNum = 1 + (int)(Math.random() * 999999);
//		Customer cust = new Customer(randomNum, firstName, lastName, Integer.valueOf(userLoginId));
//		try {
//			cDao.addCustomer(cust);
//			cust =  (Customer) ConnectionFactory.getConnection().where(randomNum, "customer", "customerid", Customer.class);
//			
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Cookie customerId = new Cookie("customerId", cust.getCustomerId().toString());
//		customerId.setMaxAge(30 * 60);
//		response.addCookie(customerId);
//		
//		out.print("new customer added" + "<br>");
//		out.print("CustomerId: " + cust.getCustomerId()+ "<br>");
//		out.print("Name: " + cust.getFirstName() + " " + cust.getLastName() + "<br>");
//		out.print("userloginId: " + cust.getUserLoginId()+ "<br>");
//		
//		dispatch = "useraccount.html";
//	
//	
//	
//	
//	RequestDispatcher rD = request.getRequestDispatcher(dispatch);
//	rD.include(request, response);
//		
//		
//		
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String customerId = request.getParameter("customerId");
	
		Cookie[] s = request.getCookies();
		for(int i=0;i<s.length;i++){  
			 if (s[i].getName().equals("customerId")) {
				 customerId = s[i].getValue();
			 }
			}  
		
		
		Customer cust = new Customer();
		
		String dispatch = "";
		
		try {
			cust = cDao.getCustomerById(Integer.valueOf(customerId));
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		out.print("Get customer info:" + "<br>");
		
		out.print("customerId " + cust.getCustomerId()+ "<br>");
		out.print("first name " + cust.getFirstName()+ "<br>");
		out.print("last name " + cust.getLastName()+ "<br>");
		out.print("userloginid " + cust.getUserLoginId()+ "<br>");
		dispatch = "useraccount.html";
	
	
	
	
	RequestDispatcher rD = request.getRequestDispatcher(dispatch);
	rD.include(request, response);
		
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		
		String dispatch = "";
		
		Customer cust = new Customer();
		PrintWriter out = response.getWriter();
		String customerId = request.getParameter("customerId");
		String column = request.getParameter("column");
		String value = request.getParameter("value");
		
		Cookie[] s = request.getCookies();
		for(int i=0;i<s.length;i++){  
			 if (s[i].getName().equals("customerId")) {
				 customerId = s[i].getValue();
			 }
			}  
		
			try {
				cust = cDao.updateCustomer(Integer.valueOf(customerId), column, value);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		dispatch = "accountmenu.html";
		
		
		out.println(column + " of " + "customerid: " + customerId  + " updated to " + value + "<br>");
		
		dispatch = "useraccount.html";
		
		RequestDispatcher rD = request.getRequestDispatcher(dispatch);
		rD.include(request, response);
		
		
	}

protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
	response.setContentType("text/html");
	
	String dispatch = "";
	

	PrintWriter out = response.getWriter();
	String customerId = request.getParameter("customerId");
	
	Customer cust = new Customer();
	
		try {
			cust = cDao.getCustomerById(Integer.valueOf(customerId));
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | InvocationTargetException
				| NoSuchMethodException | SecurityException | NoSuchFieldException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cDao.deleteCustomer(cust);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	dispatch = "accountmenu.html";
	
	out.print("Customer " + customerId + " deleted");
	
	RequestDispatcher rD = request.getRequestDispatcher(dispatch);
	rD.include(request, response);
	
}
	
	

}
