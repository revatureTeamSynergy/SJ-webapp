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
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		
		String dispatch = "";
		

		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userLoginId = request.getParameter("userLoginId");
		
		
		
		int randomNum = 1 + (int)(Math.random() * 999999);
		Customer cust = new Customer(randomNum, firstName, lastName, Integer.valueOf(userLoginId));
		try {
			cDao.addCustomer(cust);
			cust =  (Customer) ConnectionFactory.getConnection().where(randomNum, "customer", "customerid", Customer.class);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print("new customer added");
		dispatch = "useraccount.html";
	
	
	
	
	RequestDispatcher rD = request.getRequestDispatcher(dispatch);
	rD.include(request, response);
		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String customerId = request.getParameter("customerId");
	
		
		
		
		Customer cust = new Customer();
		
		String dispatch = "";
		
		try {
			cust = cDao.getCustomerById(Integer.valueOf(customerId));
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		out.print("get customer");
		
		out.print("customerId " + cust.getCustomerId());
		out.print("first name " + cust.getFirstName());
		out.print("last name " + cust.getLastName());
		out.print("userloginid " + cust.getUserLoginId());
		dispatch = "useraccount.html";
	
	
	
	
	RequestDispatcher rD = request.getRequestDispatcher(dispatch);
	rD.include(request, response);
		
	}
	
protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		
		String dispatch = "";
		
		Customer cust = new Customer();
		PrintWriter out = response.getWriter();
		String customerId = request.getParameter("customerId");
		String column = request.getParameter("column");
		String value = request.getParameter("value");
		
		try {
			cust = cDao.updateCustomer(Integer.valueOf(customerId), column, value);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		cDao.deleteCustomer(cust);
	} catch (SecurityException | IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchFieldException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
