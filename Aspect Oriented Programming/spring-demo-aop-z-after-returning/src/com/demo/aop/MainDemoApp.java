package com.demo.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aop.dao.AccountDAO;
import com.demo.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDao =
				context.getBean("membershipDAO", MembershipDAO.class);
		
		theMembershipDao.addAccount();
		
		// call the business method
		Account myAccount = new Account();
		myAccount.setLevel("platin");
		myAccount.setName("sena");
		
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// call accountDAO getter-setter
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		theMembershipDao.addSomething();
		theMembershipDao.goToSleep();
		
		// close the context
		context.close();
	}
}
