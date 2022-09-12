package com.revature.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.UserLogin;

public class UserLoginDao {
	
	Logger consoleLogger;
	
	Logger fileLogger;
	
	public UserLoginDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
	}
	
	public int insert(UserLogin uLog) {
		
			
			// Capture Session
			Session ses = HibernateUtil.getSession();
			
			// Import Transaction from hibernate not JPA
			Transaction tx = ses.beginTransaction();
			
			int pk = (int) ses.save(uLog); // The save() session method performs an insert on the DB
			
			try {
				tx.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fileLogger.debug("UserLogin insert exception");
			}
			
			return pk;
		}
	
	@SuppressWarnings("deprecation")
	public UserLogin getUserLoginByUsername(String username) {
		
		
			

			return (UserLogin) HibernateUtil.getSession().createQuery("from UserLogin where username = :uid").setParameter("uid", username).uniqueResult(); 
			//we get user object from session object using method session.get(Class arg1, Serializable arg2) here arg2 is primary key or id of the fetching object and arg1 is the what the model object we want to retrieve from database.

		

			
			
		
		
	}
	
	public UserLogin update(UserLogin uLog) {
		
		
		
		Session ses = HibernateUtil.getSession();
		ses.update(uLog); 
				
	
		 return uLog;
		
		
	}
	
	public void delete(UserLogin uLog) {
		
		Session ses = HibernateUtil.getSession();
		ses.delete(uLog); 
	}

}
