package com.demo.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.aop.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.demo.aop.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint 
			theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=================> Executing  @Around on method: " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// execute method
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Throwable e) {

			// log the exception
			myLogger.warning(e.getMessage());
			
			// rethrow exception
			throw e;
			
		}
				
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display
		long duration = end - begin;
		myLogger.info("\\n=================> Duration: " + duration / 1000.0 + "seconds");
		
		return result;
	}

	@After("execution(* com.demo.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinalltFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=================> Executing  @After (finally) on method: " 
				+ method);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.demo.aop.dao.AccountDAO.findAccounts(..))",
			throwing = "exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable exc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=================> Executing  @AfterThrowing on method: " + method);

		// log exception
		myLogger.info("\n=================> Exception: " + exc);

	}
	
	// add a new advice
	@AfterReturning(
			pointcut = "execution(* com.demo.aop.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=================> Executing  @AfterReturning on method: " + method);
		
		// print out result of method call
		myLogger.info("\n=================> result is: " + result);
		
		// let's post process data 
		
		// contvert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n=================> result is: " + result);

	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through account
		for (Account tempAccount : result) {
			
			// get uppercase
			String upperName = tempAccount.getName().toUpperCase();
			
			// update name on the account
			tempAccount.setName(upperName);

		}
		
	}


	@Before("com.demo.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) { // jp has metadata
		myLogger.info("\n=========> Executing @Before advice om addAccount()");
	
		// display method signature 
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
			}
		}
		
		
	}
}





