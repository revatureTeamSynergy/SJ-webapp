
package com.revature.repository;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.ORM.Database.Database;


public class ConnectionFactory {
	
	
	public static Database getConnection() throws SQLException {
		
	
		Database db = null;
		
		try {
//		 connection = DriverManager.getConnection(url, user, password);
			Class.forName("org.postgresql.Driver");
		 
		  db = new Database(System.getenv("P1_DATABASE_URL"), System.getenv("P1_DATABASE_USERNAME"), System.getenv("P1_DATABASE_PASSWORD"));
		
		} catch (SQLException e) {
			System.out.println("Connection Failure");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return db;
		
	}

}
