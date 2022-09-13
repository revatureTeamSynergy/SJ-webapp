package com.revature.repository;


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
	
	public UserLogin insert(UserLogin uLog) {
		UserLogin uLog2 = new UserLogin();
			
		try {
			 ConnectionFactory.getConnection().insert(uLog2);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uLog2;
		}
	
	@SuppressWarnings("deprecation")
	public UserLogin getUserLoginByUsername(String username) {
		return null;
	

			
			
		
		
	}
	
	public UserLogin update(UserLogin uLog) {
		
		
		
	
		 return uLog;
		
		
	}
	
	public void delete(UserLogin uLog) {
		
	
	}

}
