package com.revature.repository;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Account;

import com.revature.services.ORM.Database.Database;

public class AccountDao {
	
	Logger consoleLogger;
	
	Logger fileLogger;
	
	
	
	public AccountDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
		
	}
	
	
	
public Account addAccount(Account acc) throws SQLException {
		
		// Capture
	

		
		try {
			 ConnectionFactory.getConnection().insert(acc);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return acc;
	}



public Account getAccountById(int accId) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, SQLException {
    Database db =  ConnectionFactory.getConnection();
    Account acc = (Account) db.where(accId, "account", "accountid", Account.class);
    System.out.println("getaccountbyId = " + acc.toString());
    return acc;
}

public Account updateAccountById(int accId, String column, String value) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, SQLException {
    Database db =  ConnectionFactory.getConnection();
    Account acc = (Account) db.where(accId, "account", "accountid", Account.class);
    
    db.update(acc, column, value);
    System.out.println("getaccountbyId = " + acc.toString());
    return acc;
}




public void deleteAccount(Account acc) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, SQLException {
	
	Database db =  ConnectionFactory.getConnection();
    db.delete(acc);
	try {
		 ConnectionFactory.getConnection().delete(acc);
		
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
	
	

}
