package com.revature.models;

public class BooleanField {
	private boolean default_;
	private boolean value;
	
	public BooleanField() {
		
	}
	public BooleanField(boolean default_) {
		this.default_ = default_;
	}

	public boolean getDefault() {
		return default_;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return this.value;
	}
}
