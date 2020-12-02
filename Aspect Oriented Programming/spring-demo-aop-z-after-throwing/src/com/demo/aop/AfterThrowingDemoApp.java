package com.demo.aop;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aop.dao.AccountDAO;
import com.demo.aop.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;
		
		try {
			// add a boolean flag to simulate exception
			boolean tripWire = true;
			theAccountDAO.findAccounts(tripWire);	
		}
		catch (Exception exc) {
			System.out.println("\n\nMain program ... caught exception" + exc);
		}
		
		
		System.out.println("main program: After Throwing Demo");
		
		System.out.println(theAccounts);
		System.err.println("\n");

		
		// close the context
		context.close();
	}
}
