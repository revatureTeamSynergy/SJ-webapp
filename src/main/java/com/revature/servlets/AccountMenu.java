package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ORM.Database.Database;
import com.revature.models.Account;
import com.revature.repository.AccountDao;
import com.revature.repository.ConnectionFactory;

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
		
		
		PrintWriter out = response.getWriter();
		String accountInitBalance = request.getParameter("accountInitBalance");
		String customerId = request.getParameter("customerId");
		Cookie[] s = request.getCookies();
		for(int i=0;i<s.length;i++){  
			 if (s[i].getName().equals("customerId")) {
				 customerId = s[i].getValue();
			 }
			}  
	
		
		
		if (customerId == null || Double.valueOf(accountInitBalance) <= 0) {
			out.println("<font color=red>Invalid account entry</font>");
			dispatch = "accountmenu.html";
			
		}
		
		Account newAccount = new Account(Integer.valueOf(customerId), Double.valueOf(accountInitBalance));
		int randomNum = 1 + (int)(Math.random() * 999999);
		newAccount.setAccountId(randomNum);
		
		System.out.println(newAccount.toString());
	
		
		try {
			aDao.addAccount(newAccount);
		} catch (SecurityException | IllegalArgumentException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatch = "accountmenu.html";
		
		
//		newAccount.insert(Account.class);
		
		out.print("Account added<br>");
		
		out.print("accountId: " + newAccount.getAccountId() + "<br>");
		out.print("balance: " + newAccount.getBalance() + "<br>");
		out.print("customerId: " + newAccount.getCustomerId() + "<br>");
		
		RequestDispatcher rD = request.getRequestDispatcher(dispatch);
		rD.include(request, response);
	
	
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		
		String dispatch = "";
		

		PrintWriter out = response.getWriter();
		String accountId = request.getParameter("accountId");
		
		Account arrL = new Account();
		String customerId = request.getParameter("customerId");
		Cookie[] s = request.getCookies();
		for(int i=0;i<s.length;i++){  
			 if (s[i].getName().equals("customerId")) {
				 customerId = s[i].getValue();
			 }
			}  
		
		try {
//			getAccount = aDao.getAccountById(Integer.valueOf(accountId));
			arrL = aDao.getAccountById(Integer.valueOf(accountId));
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
		
			if (arrL.customerid != Integer.valueOf(customerId)) {
				out.print("You can only view accounts that you own.");
			} else {
				out.print("accountId: " + arrL.getAccountId() + "<br>");
				out.print("balance: " + arrL.getBalance() + "<br>");
			}
	
		
		RequestDispatcher rD = request.getRequestDispatcher(dispatch);
		rD.include(request, response);
		
		
	}
	
protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		
		String dispatch = "";
		

		PrintWriter out = response.getWriter();
		String accountId = request.getParameter("accountId");
		String column = request.getParameter("column");
		String value = request.getParameter("value");
		
		try {
			aDao.updateAccountById(Integer.valueOf(accountId), column, value);
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
		}
		
		dispatch = "accountmenu.html";
		
		out.print("account updated" + "<br>");
		out.print("accountId: " + accountId + "<br>");
		out.print("column: " + column + "<br>");
		out.print("value: " + value + "<br>");
		
		RequestDispatcher rD = request.getRequestDispatcher(dispatch);
		rD.include(request, response);
		
		
	}

protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
	response.setContentType("text/html");
	
	String dispatch = "";
	

	PrintWriter out = response.getWriter();
	String accountId = request.getParameter("accountId");
	
	Account getAccount = new Account();
	try {
		getAccount = aDao.getAccountById(Integer.valueOf(accountId));
		aDao.deleteAccount(getAccount);
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
	
	out.print("account deleted" + "<br>");
	
	RequestDispatcher rD = request.getRequestDispatcher(dispatch);
	rD.include(request, response);
	
}


	

}
