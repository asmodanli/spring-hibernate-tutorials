package com.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// where wee add all of our related advices for logging
	// .. -> match on any number of arguments
	// start with @Before
	// @Before("execution(public void com.demo.aop.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(public * add*())")
	// @Before("execution( * add*(com.demo.aop.Account, ..))")
	// @Before("execution(* add*(Account))") - hata - use qualified names
	// @Before("execution( * add*(..))") // matches for any parameters
	@Before("execution( * com.demo.aop.dao.*.*(..))") //any class.any method any number of parameters
	public void beforeAddAccountAdvice() { 
		System.out.println("\n=========> Executing @Before advice om addAccount()");
	}
}
