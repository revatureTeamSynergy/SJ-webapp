package com.revature.models;

public class ForeignKey <T>{
	public T obj;
	public boolean null_;
	public String onDelete;
	
	public ForeignKey() {
		
	}
	
	public ForeignKey(boolean null_) {
		this.null_ = null_;
		
	}
	public ForeignKey(boolean null_, String onDelete) {
		this.null_ = null_;
		this.onDelete = onDelete;
	}

	public boolean getNull() {
		return null_;
	}	
}
