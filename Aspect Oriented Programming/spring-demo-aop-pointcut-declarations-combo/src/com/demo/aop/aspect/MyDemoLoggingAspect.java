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
	
	// create pointcut for getter
	@Pointcut("execution(* com.demo.aop.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter
	@Pointcut("execution(* com.demo.aop.dao.*.set*(..))")
	private void setter() {}

	// create pointcut include package, exclude getter-seter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() { 
		System.out.println("\n=========> Executing @Before advice om addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void PerformApiAnalytics() {
		System.out.println("=========== > Performing API Analytic - forDaoPackageNoGetterSetter");
	}
}
