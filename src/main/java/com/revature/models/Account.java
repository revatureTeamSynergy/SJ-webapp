package com.revature.models;

import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="account", schema="public")
public class Account {
	
	
	@Id
	@Column(name="accountid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int accountid;
	
	@Column(name="balance")
	public double balance;
	
	@Column(name="customerid")
	public int customerid;

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
		return "Accounts [accountId=" + accountid + ", balance=" + balance + ", customerId=" + customerid + "]";
	}
	
	
	
	

}
