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

public class TransactionMenu extends HttpServlet{
	
	AccountDao aDao = new AccountDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		
		String dispatch = "";
		

		PrintWriter out = response.getWriter();
		String accountId = request.getParameter("accountId");
		String withdraw = request.getParameter("withdraw");
		String deposit = request.getParameter("deposit");
		
		if (withdraw == "") { 
			withdraw = "0";
		}
		if (deposit == "") {
			deposit = "0";
			
		}
		
		Double dep = Double.valueOf(deposit) ;
		Double wit = Double.valueOf(withdraw);
		String resultStr = "";
		
		try {
			Account acc = aDao.getAccountById(Integer.valueOf(accountId));
			dep = dep + acc.getBalance();
			Double result = dep - wit;
			resultStr = String.valueOf(result);
			aDao.updateAccountById(Integer.valueOf(accountId), "balance", resultStr);
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
		
		dispatch = "transactionmenu.html";
		
		out.print("account updated" + "<br>");
		out.print("accountId: " + accountId + "<br>");
		out.print("balance: " + resultStr + "<br>");
		
		
		RequestDispatcher rD = request.getRequestDispatcher(dispatch);
		rD.include(request, response);
	
	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
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
		
		dispatch = "transactionmenu.html";
		
		out.print("Bank Account " + accountId + "deleted" + "<br>");
		
		RequestDispatcher rD = request.getRequestDispatcher(dispatch);
		rD.include(request, response);
		
	}

}
