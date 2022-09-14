
package com.revature.repository;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.ORM.Database.Database;


public class ConnectionFactory {
	
	
	public static Database getConnection() throws SQLException {
		
		String url = System.getenv("P1_DATABASE_URL");
		String user = System.getenv("P1_DATABASE_USERNAME");
		String pass = System.getenv("P1_DATABASE_PASSWORD");
	
		Database db = null;
		
		try {

			Class.forName("org.postgresql.Driver");
		 
		  db = new Database(url, user, pass);
		
		} catch (SQLException e) {
			System.out.println("Connection Failure");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return db;
		
	}

}
