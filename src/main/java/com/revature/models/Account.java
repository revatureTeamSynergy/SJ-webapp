package com.revature.models;

import java.util.Objects;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.revature.ORM.Annot.Table;


@Table(name="account")
public class Account {
	
	 public int accountid;
	  public int customerid;
	   
	    public double balance;

//	public Account(double balance, int customerId) {
//		super();
//		this.balance = balance;
//		this.customerid = customerId;
//	}
	
//	public Account(int accountid, double balance, int customerId) {
//		super();
//		this.accountid = accountid;
//		this.balance = balance;
//		this.customerid = customerId;
//	}

	public Account() {
		// TODO Auto-generated constructor stub
	}
	


	public Account(int customerid, double balance) {
	super();
	this.customerid = customerid;
	this.balance = balance;
}



	public int getAccountId() {
		return accountid;
	}

	public void setAccountId(int accountId) {
		this.accountid = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerid;
	}

	public void setCustomerId(int customerId) {
		this.customerid = customerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountid, balance, customerid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return accountid == other.accountid
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& customerid == other.customerid;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountid + ", balance=" + balance + ", customerId=" + customerid + "]";
	}
	
	
	
	

}
