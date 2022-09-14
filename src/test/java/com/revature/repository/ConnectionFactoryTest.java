package com.revature.repository;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConnectionFactoryTest {
	
	 @BeforeAll
	   public void setUp(){
	      ConnectionFactory conF = new ConnectionFactory();
	     
	   }
	 
	 @Test
	 public void getConnection() {
		 
	 }

}
