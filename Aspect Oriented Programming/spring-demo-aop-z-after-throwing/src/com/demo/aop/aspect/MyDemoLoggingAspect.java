package com.demo.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@AfterThrowing(
			pointcut = "execution(* com.demo.aop.dao.AccountDAO.findAccounts(..))",
			throwing = "exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable exc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=================> Executing  @AfterThrowing on method: " + method);

		// log exception
		System.out.println("\n=================> Exception: " + exc);

	}
	
	// add a new advice
	@AfterReturning(
			pointcut = "execution(* com.demo.aop.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=================> Executing  @AfterReturning on method: " + method);
		
		// print out result of method call
		System.out.println("\n=================> result is: " + result);
		
		// let's post process data 
		
		// contvert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n=================> result is: " + result);

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
		System.out.println("\n=========> Executing @Before advice om addAccount()");
	
		// display method signature 
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
		
		
	}
}





