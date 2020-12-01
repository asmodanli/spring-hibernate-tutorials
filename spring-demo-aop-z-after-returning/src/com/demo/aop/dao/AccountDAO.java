package com.demo.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.aop.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	// add a new method - > findAccounts()

	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<Account>();
		
		// create sample accounts
		Account temp1 = new Account("john", "silver");
		Account temp2 = new Account("sena", "gold");
		Account temp3 = new Account("ayse", "platinium");

		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
			
		return myAccounts;
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + "DOING DB WORK: ADD ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + "DOING SOME WORK: DAO");
		return true;
	
	}

	public String getName() {
		System.out.println(getClass() + " getname");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " setname");

		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + "getservicecode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + "setservicecode");
		this.serviceCode = serviceCode;
	}
	
	
}
