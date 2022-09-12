package com.revature.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.ConnectionFactory;
import com.revature.models.Customer;
import com.revature.models.UserLogin;

public class CustomerDao {
	
	Logger consoleLogger;
	
	Logger fileLogger;
	
	public CustomerDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
	}
	
	
public int addCustomer(Customer cust) {
		
		// Capture Session
		Session ses = HibernateUtil.getSession();
		
		// Import Transaction from hibernate not JPA
		Transaction tx = ses.getTransaction();
		
		int pk = (int) ses.save(cust); // The save() session method performs an insert on the DB
		
		try {
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pk;
	}

public Customer getCustomer(UserLogin userLoginId) {
	Customer cust = new Customer();
	Session ses = HibernateUtil.getSession();
	
	ses.find(Customer.class, userLoginId);
	
	return (Customer) ses.createQuery("from Customer where customer_id = :uid").setParameter("uid", cust.getCustomerId()).uniqueResult(); 
}

public Customer updateCustomer(Customer cust) {
	
	Session ses = HibernateUtil.getSession();
	ses.update(cust); 
			
	 return (Customer) ses.createQuery("from Customer where customer_id = :uid").setParameter("uid", cust.getCustomerId()).uniqueResult(); 
	
	
}

public void deleteCustomer(Customer cust) {
	
	Session ses = HibernateUtil.getSession();
	ses.delete(cust); 
	
}

}
