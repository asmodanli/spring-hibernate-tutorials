package com.demo.aop.dao;

import org.springframework.stereotype.Component;

import com.demo.aop.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + "DOING DB WORK: ADD ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + "DOING SOME WORK: DAO");
		return true;
			
	}
}
