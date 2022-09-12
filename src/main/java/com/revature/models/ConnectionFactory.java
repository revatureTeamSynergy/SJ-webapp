package com.revature.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static String url;
	
	public static Connection connection;
	
	private static int port = 5432;
	
	private static String databaseName = "postgres";
	
	private static String databaseUser = "postgres";
	
	private static String databasePassword = "bubblegum";
	
	private static String host = "p1data.cdiwjc2x9nug.us-east-1.rds.amazonaws.com";
	
	public static Connection getConnection() throws SQLException {
		
		try {
			url = "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;
			
			connection = DriverManager.getConnection(url, databaseUser, databasePassword);
			
		} catch (SQLException e) {
			System.out.println("Connection Failure" + url);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
				
	}
}