package com.demo.aop;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.aop.dao.AccountDAO;
import com.demo.aop.dao.MembershipDAO;
import com.demo.aop.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain program: AroundDemoApp");
		System.out.println("Calling getFortune");
		String data = theFortuneService.getFortune();
		System.out.println("fortune: " + data);
		System.out.println("finito");
		
		// close the context
		context.close();
	}
}
