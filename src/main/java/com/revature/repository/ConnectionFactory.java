
package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private static String url = System.getenv("P1_DATABASE_URL");
	private static String user = System.getenv("P1_DATABASE_USERNAME");
	private static String password = System.getenv("P1_DATABASE_PASSWORD");
	
	public static Connection getConnection() throws SQLException {
		
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
		
	}

}
