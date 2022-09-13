package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.ConnectionFactory;
import com.revature.services.ORM.Database.Database;

public class AccountMenu extends HttpServlet{
	
	Database db = null;
	AccountDao aDao = new AccountDao();
	
	public void init() {
		try {
			ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		response.setContentType("text/html");
		
		String dispatch = "";
		
		System.out.println("test");
		PrintWriter out = response.getWriter();
		String accountInitBalance = request.getParameter("accountInitBalance");
		String customerId = request.getParameter("customerId");
		
		if (customerId == null || Double.valueOf(accountInitBalance) <= 0) {
			out.println("<font color=red>Invalid account entry</font>");
			dispatch = "accountmenu.html";
			
		}
		
		Account newAccount = new Account();
		
		newAccount.setBalance(Double.valueOf(accountInitBalance));
		
		newAccount.setCustomerId(Integer.valueOf(customerId));
		
		System.out.println("newacc: " + newAccount.toString());
		
		try {
			aDao.addAccount(newAccount);
		} catch (SecurityException | IllegalArgumentException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatch = "accountmenu.html";
		
		
//		newAccount.insert(Account.class);
		
		out.print("account added");
		
		RequestDispatcher rD = request.getRequestDispatcher(dispatch);
		rD.include(request, response);
	
	
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		
		String dispatch = "";
		

		PrintWriter out = response.getWriter();
		String accountId = request.getParameter("accountId");
		Account getAccount =  new Account();
		
		
		try {
			getAccount = aDao.getAccountById(Integer.valueOf(accountId));
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
		}
		dispatch = "accountmenu.html";
		
		out.print("account obtained");
		out.print("accountId: " + getAccount.getAccountId());
		out.print("balance: " + getAccount.getBalance());
		out.print("customerId: " + getAccount.getCustomerId());
		
		System.out.print("accountId: " + getAccount.getAccountId());
		System.out.print("balance: " + getAccount.getBalance());
		System.out.print("customerId: " + getAccount.getCustomerId());
		
		RequestDispatcher rD = request.getRequestDispatcher(dispatch);
		rD.include(request, response);
		
		
	}
	
protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		
		String dispatch = "";
		

		PrintWriter out = response.getWriter();
		String accountId = request.getParameter("accountId");
		String customerId = request.getParameter("customerId");
		
		
		
		
	}

protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
	response.setContentType("text/html");
	
	String dispatch = "";
	

	PrintWriter out = response.getWriter();
	String accountId = request.getParameter("accountId");
	String customerId = request.getParameter("customerId");
	
	
	
	
	
}


	

}
