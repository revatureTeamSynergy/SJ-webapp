package com.revature.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	static String regexUsername = ".*[., _, !, #, $, %, ^, &, *, (, ), -, +, =, /, ?, `, ~, <, >].*";

	static String regexPassword = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";

	static String regexName = "^[A-Za-z]{1,15}$";

	public static boolean isValidUsername(String username) {
		if (((username.matches(regexUsername)) || (username.length() < 8 && username.length() > 20))) {

			return false;
		} else {
			return true;
		}

	}

	public static boolean isValidPass(String password) {

		Pattern pattern = Pattern.compile(regexPassword);
		Matcher matcher = pattern.matcher(password);
		return matcher.find();
	}

	public static boolean isValidName(String name) {

		Pattern pattern = Pattern.compile(regexName);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	

}
