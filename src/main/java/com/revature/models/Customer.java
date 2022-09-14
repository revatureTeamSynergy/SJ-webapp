package com.revature.models;


import java.util.Objects;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.revature.ORM.Annot.Table;


@Table(name = "customer" )
public class Customer{
	
	public int  customerid;

	public String firstname;

	public String lastname;
	
	public int userloginid;
	
	
	

	public Customer(Integer customerId, String firstName, String lastName, Integer userLoginId) {
		super();
		this.customerid = customerId;
		this.firstname = firstName;
		this.lastname = lastName;
		this.userloginid = userLoginId;
	}
	
	public Customer( String firstName, String lastName, Integer userLoginId) {
		super();
		
		this.firstname = firstName;
		this.lastname = lastName;
		this.userloginid = userLoginId;
	}



	public Customer() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public int hashCode() {
		return Objects.hash(customerid, firstname, lastname, userloginid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerid, other.customerid) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(userloginid, other.userloginid);
	}

	public Integer getCustomerId() {
		return customerid;
	}

	public void setCustomerId(Integer customerId) {
		this.customerid = customerId;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public Integer getUserLoginId() {
		return userloginid;
	}

	public void setUserLoginId(Integer userLoginId) {
		this.userloginid = userLoginId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerid + ", firstName=" + firstname + ", lastName=" + lastname
				+ ", userLoginId=" + userloginid + "]";
	}

	
	
	

}
