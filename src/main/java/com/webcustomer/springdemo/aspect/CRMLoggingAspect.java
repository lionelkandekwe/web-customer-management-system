package com.webcustomer.springdemo.aspect;

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
	
	//setup logger
	
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.webcustomer.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.webcustomer.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.webcustomer.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	
	@Before("forAppFlow()")
	public void beforeAdvice(JoinPoint theJoinPoint) {
		
		// display method
		
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("====> In @Before: calling method "+theMethod);
		
		//display arguments to the method
		
		//get the arguments
		Object[]args=theJoinPoint.getArgs();
		
		//loop thru and display args
		
		for(Object tempArg:args) {
			myLogger.info("====> Argument: "+tempArg);
		}
		
		
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult"
			)
	public void afterReturningAdvice(JoinPoint theJoinPoint,Object theResult) {
		
		//Display method returning from
		
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("====> In @AfterReturning: calling method "+theMethod);
		
		// display data returned
		
		myLogger.info("====> Result: "+theResult);
		
	}

}
