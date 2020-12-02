package com.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution( * com.demo.aop.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter
	@Pointcut("execution(* com.demo.aop.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter
	@Pointcut("execution(* com.demo.aop.dao.*.set*(..))")
	public void setter() {}

	// create pointcut include package, exclude getter-seter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}	

}
