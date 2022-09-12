package com.revature.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Account;

public class AccountDao {
	
	Logger consoleLogger;
	
	Logger fileLogger;
	
	public AccountDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
		
	}
	
public int addAccount(Account acc) {
		
		// Capture Session
		Session ses = HibernateUtil.getSession();
		
		// Import Transaction from hibernate not JPA
		Transaction tx = ses.getTransaction();
		
		int pk = (int) ses.save(acc); // The save() session method performs an insert on the DB
		
		try {
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pk;
	}

public Account getAccountById(int acc) {
	Account account = new Account();
	Session ses = HibernateUtil.getSession();
	
	account = ses.find(Account.class, "account_id");
	
	return account;
}
	
	

}
