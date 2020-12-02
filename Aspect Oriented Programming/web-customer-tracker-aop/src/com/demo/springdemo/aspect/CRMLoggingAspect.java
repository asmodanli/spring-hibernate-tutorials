package com.demo.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	// setup pointcut declarations
	@Pointcut("execution(* com.demo.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// same for service and dao 
	@Pointcut("execution(* com.demo.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.demo.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	// add @Before
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinpoint){
		
		// display method we are calling
		String theMethod = theJoinpoint.getSignature().toLongString();
		myLogger.info("======> @Before calling method : " + theMethod);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = theJoinpoint.getArgs();
		
		// loop thru and display args
		for(Object tempArg : args) {
			myLogger.info("======> argument: " + tempArg);
		}
	}
	
	// add @AfterReturning
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toLongString();
		myLogger.info("======> @Before calling method : " + theMethod);
		
		// display data returned
		myLogger.info("======> result: " + theResult);
				
	}
	
	
	
	
	
	
	
	
	
}
