package com.revature.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.repository.ConnectionFactory;
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
	return 0;
		

	}

public Customer getCustomer(UserLogin userLoginId) {
	return null;
	
}

public Customer updateCustomer(Customer cust) {
	return cust;
	
	
	
}

public void deleteCustomer(Customer cust) {
	
	
	
}

}
