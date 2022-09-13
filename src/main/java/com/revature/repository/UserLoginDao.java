package com.revature.repository;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.UserLogin;
import com.revature.services.ORM.Database.Database;

public class UserLoginDao {
	
	Logger consoleLogger;
	
	Logger fileLogger;
	
	public UserLoginDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
	}
	
	public UserLogin addUserLogin(UserLogin uLog) {
	
		try {
			 ConnectionFactory.getConnection().insert(uLog);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uLog;

		}
	
	@SuppressWarnings("deprecation")
	public UserLogin getUserLoginByUsername(String username) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		
		
	    Database db =  ConnectionFactory.getConnection();
	    UserLogin uLog = (UserLogin) db.where(username, "userlogin", "username", UserLogin.class);
	    
	    return uLog;
		

	

			
			
		
		
	}
	
public UserLogin getUserLoginById(int userLoginId) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		
		
	    Database db =  ConnectionFactory.getConnection();
	    UserLogin uLog = (UserLogin) db.where(userLoginId, "userlogin", "userloginid", UserLogin.class);
	    
	    return uLog;
		

	

			
			
		
		
	}

	public UserLogin updateUserLogin(int userloginid, String column, String value) throws Throwable {
		
		Database db =  ConnectionFactory.getConnection();
		UserLogin uLog = (UserLogin) db.where(userloginid, "userlogin", "userloginid", UserLogin.class);
	    
	    db.update(uLog, column, value);
	    
	    fileLogger.debug(column + " of " + "userloginid: " + userloginid  + " updated to " + value);
	    
	    
		
	
		 return uLog;
		
		
	}
	
	public UserLogin deleteUserLogin(int userloginid) throws Throwable{
		
		Database db =  ConnectionFactory.getConnection();
		UserLogin uLog = (UserLogin) db.where(userloginid, "userlogin", "userloginid", UserLogin.class);
	    db.delete(uLog);
		return uLog;
	}

}
