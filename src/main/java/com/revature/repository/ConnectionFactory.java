
package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.services.ORM.Database.Database;


public class ConnectionFactory {
	public static Connection connection;
	private static String url = System.getenv("P1_DATABASE_URL");
	private static String user = System.getenv("P1_DATABASE_USERNAME");
	private static String password = "greenjelly89#";
	
	
	public static Database getDatabase() throws Throwable {
		Database db = new Database(System.getenv("P1_DATABASE_URL"), System.getenv("P1_DATABASE_USERNAME"), "greenjelly89#");
		return db;
	}

	
	public static Database getConnection() throws SQLException {
		
		System.out.println(url + user + password);
		Database db = null;
		
		try {
//		 connection = DriverManager.getConnection(url, user, password);
			Class.forName("org.postgresql.Driver");
		 
		  db = new Database(System.getenv("P1_DATABASE_URL"), System.getenv("P1_DATABASE_USERNAME"), "greenjelly89#");
		
		} catch (SQLException e) {
			System.out.println("Connection Failure" + url);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return db;
		
	}

}
