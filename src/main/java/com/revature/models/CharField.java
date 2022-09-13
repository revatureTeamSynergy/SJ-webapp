package com.revature.models;

public class CharField {
	private int maxLength;
	private boolean null_;
	private boolean unique;
	private String value;
	
	public CharField() {
		
	}
	
	public CharField(int maxLength) {
		this.maxLength = maxLength;
	}
	
	public CharField(int maxLength, boolean null_) {
		this.maxLength = maxLength;
		this.null_ = null_;
	}
	
	public CharField(int maxLength, boolean null_, boolean unique) {
		this.maxLength = maxLength;
		this.null_ = null_;
		this.unique = unique;
	}

	public int getMaxLength() {
		return maxLength;
	}
	
	public boolean getNull() {
		return null_;
	}
	
	public boolean getUnique() {
		return unique;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value; 
	}
}
