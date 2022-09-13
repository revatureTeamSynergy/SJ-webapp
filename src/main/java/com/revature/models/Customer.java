package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer", schema="public")

public class Customer implements Serializable{
	
	
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	public CharField  customerId = new CharField(120, true, true);
	
	public final String  sqlId = "customerId";
	
	public String getSqlId() {return sqlId; };
	
	@Column(name = "first_name", nullable=false)
	public CharField firstName  = new CharField(120, true);
	
	@Column(name = "last_name", nullable=false)
	public CharField lastName = new CharField(120, true);
	
	public String getSqlIdVoid() {
		return sqlId;
	}



	@Column(name = "user_login_id", unique=true, nullable=false)
	
	public CharField userLoginId = new CharField(120, true);

	public Customer(CharField firstName, CharField lastName, CharField userLoginId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userLoginId = userLoginId;
	}

	public Customer() {
		super();
	}

	public CharField getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CharField customerId) {
		this.customerId = customerId;
	}

	public CharField getFirstName() {
		return firstName;
	}

	public void setFirstName(CharField firstName) {
		this.firstName = firstName;
	}

	public CharField getLastName() {
		return lastName;
	}

	public void setLastName(CharField lastName) {
		this.lastName = lastName;
	}

	public CharField getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(CharField userLoginId) {
		this.userLoginId = userLoginId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, firstName, lastName, userLoginId);
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
		return customerId == other.customerId && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && userLoginId == other.userLoginId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userLoginId=" + userLoginId + "]";
	}
	
	

}
