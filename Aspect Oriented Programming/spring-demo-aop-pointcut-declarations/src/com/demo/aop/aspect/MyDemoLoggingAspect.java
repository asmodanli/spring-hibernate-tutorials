package com.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution( * com.demo.aop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() { 
		System.out.println("\n=========> Executing @Before advice om addAccount()");
	}
	
	@Before("forDaoPackage()")
	public void PerformApiAnalytics() {
		System.out.println("=========== > Performing API Analytic");
	}
}
