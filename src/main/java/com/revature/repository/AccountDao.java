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

public Account getAccountById(Integer accId) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException, SQLException {
	Account acc = (Account) ConnectionFactory.getConnection().where(accId, "account", "accountid", Account.class);
	
	Account acc2 = new Account();
	
	acc2.setAccountId(accId);
	acc2.setBalance(acc.getBalance());
	acc2.setCustomerId(acc.getCustomerId());
	
	
	
	//Object account = db.where("BobRoss", "account", "usernames", ObjTest2.class);
	//ObjTest2 acc = (ObjTest2) account;
	//System.out.println(acc.acc_balance );
	

	
	System.out.println(acc2.toString());
	return acc2;
}

public void deleteAccount(Account acc) {
	try {
		 ConnectionFactory.getConnection().delete(acc);
		
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
	
	

}
