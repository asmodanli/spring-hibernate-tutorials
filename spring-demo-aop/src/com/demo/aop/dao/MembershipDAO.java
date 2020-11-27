package com.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(getClass() + " ADDING MEMBERSHIP ACCOUNT");
	}
	
	public boolean addSomething() {
		System.out.println(getClass() + " ADDING SOMETHING ACCOUNT TRUE");
		
		return true;
	}
}
