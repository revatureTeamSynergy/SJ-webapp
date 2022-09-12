package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "user_login", schema="public")
public class UserLogin {
	
	@Id
	@Column(name="user_login_id" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_login_Id;
	
	@Column(name= "username", unique=true,nullable=false)
	private String username;
	
	@Column(name= "password", unique=true,nullable=false)
	private String password;
	

	public UserLogin(String username, String password, int customerId) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserLogin() {
		// TODO Auto-generated constructor stub
	}

	public int getUserLoginId() {
		return user_login_Id;
	}

	public void setUserLoginId(int userLoginId) {
		this.user_login_Id = userLoginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}





	@Override
	public String toString() {
		return "UserLogin [userLoginId=" + user_login_Id + ", username=" + username + ", password=" + password
				+ ", customerId= ]";
	}
	
	
	
	

}
