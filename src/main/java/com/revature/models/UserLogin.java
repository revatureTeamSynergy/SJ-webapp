package com.revature.models;

import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.revature.services.ORM.Annot.Table;


@Table(name= "userlogin")
public class UserLogin {

	public int userloginid;
	
	
	public String username;
	

	public String password;
	

	public UserLogin(int userloginid, String username, String password) {
		super();
		this.userloginid = userloginid;
		this.username = username;
		this.password = password;
	}

//	public UserLogin(String username, String password) {
//		super();
//		this.username = username;
//		this.password = password;
//	}

	public UserLogin() {
		// TODO Auto-generated constructor stub
	}

	public int getUserloginid() {
		return userloginid;
	}

	public void setUserloginid(int userloginid) {
		this.userloginid = userloginid;
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
		return "UserLogin [userloginid=" + userloginid + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, userloginid, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		return Objects.equals(password, other.password) && userloginid == other.userloginid
				&& Objects.equals(username, other.username);
	}


	

	
	
	

}
