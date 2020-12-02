package com.demo.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	

	@Before("com.demo.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void PerformApiAnalytics() {
		System.out.println("=========== > Performing API Analytic - forDaoPackageNoGetterSetter");
	}
	

}
