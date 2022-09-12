package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Customer;
import com.revature.repository.CustomerDao;

public class UserAccount extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	
		Cookie[] cookies = request.getCookies();
		System.out.println("heyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy" + " " + cookies[1]);
		out.println(cookies[0]);
		System.out.println(response.getHeader(null));
		
		CustomerDao cDao = new CustomerDao();
		
		Customer cust = cDao.getCustomer(null);
		
		String dispatch = "";
		
	}
	
	

}
