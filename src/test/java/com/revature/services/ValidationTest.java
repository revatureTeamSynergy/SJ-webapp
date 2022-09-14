package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ValidationTest {
	
	
	@Test
	public void isValidUsername() {
		boolean isVal = Validation.isValidUsername("$$$");
		
		assertFalse(isVal);
	}
	
	@Test
	public void isValidPassword() {
		boolean isVal = Validation.isValidPass("123");
		
		assertFalse(isVal);
	}
	
	@Test
	public void isValidName() {
		boolean isVal = Validation.isValidName("123");
		
		assertFalse(isVal);
	}
	

}