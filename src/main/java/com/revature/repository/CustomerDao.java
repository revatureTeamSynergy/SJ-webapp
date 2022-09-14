package com.revature.repository;

import java.lang.reflect.InvocationTargetException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.repository.ConnectionFactory;
import com.revature.ORM.Database.Database;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.UserLogin;

public class CustomerDao {
	
	Logger consoleLogger;
	
	Logger fileLogger;
	
	public CustomerDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
	}
	
	
public Customer addCustomer(Customer cust) {

	try {
		 ConnectionFactory.getConnection().insert(cust);
		
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return cust;

	}

public Customer getCustomerById(int customerid) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
	 Database db =  ConnectionFactory.getConnection();
	    Customer cust = (Customer) db.where(customerid, "customer", "customerid", Customer.class);
	   
	    return cust;
	
}

public Customer getCustomerByUserLoginId(int userloginid) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
	 Database db =  ConnectionFactory.getConnection();
	    Customer cust = (Customer) db.where(userloginid, "customer", "userloginid", Customer.class);
	   
	    return cust;
	
}

public Customer updateCustomer(int customerid, String column, String value) throws Throwable {
	
		Database db =  ConnectionFactory.getConnection();
		Customer cust = (Customer) db.where(customerid, "customer", "customerid", Customer.class);
	    
	    db.update(cust, column, value);
	    
	    fileLogger.debug(column + " of " + "customerid: " + customerid  + " updated to " + value);
	    
	    return cust;
	
	
	
}

public void deleteCustomer(Customer cust) throws Throwable {
	
	Database db =  ConnectionFactory.getConnection();
    db.delete(cust);
	
	
	
}

}
