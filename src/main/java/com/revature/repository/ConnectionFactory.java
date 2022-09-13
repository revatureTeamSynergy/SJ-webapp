
package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://p1data.cdiwjc2x9nug.us-east-1.rds.amazonaws.com:5432/";
		String user = "postgres";
		String password = "bubblegum";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
		
	}

}
