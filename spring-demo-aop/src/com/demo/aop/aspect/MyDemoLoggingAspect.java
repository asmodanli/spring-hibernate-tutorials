package com.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// where wee add all of our related advices for logging
	
	// start with @Before
	// @Before("execution(public void com.demo.aop.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	@Before("execution(public * add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=========> Executing @Before advice om addAccount()");
	}
}
