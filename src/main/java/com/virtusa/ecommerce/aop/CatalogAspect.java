package com.virtusa.ecommerce.aop;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CatalogAspect {

	private static final Logger LOG = Logger.getLogger(CatalogAspect.class);

//	@Before("execution(* com.virtusa.ecommerce.controller..*.*(..))")
	public void logBeforeMyMethod(JoinPoint joinPoint) {
		LOG.info("logBefore :: " + joinPoint.getSignature().getName() + "start time ::" + new Date());
	}

	//@After("execution(* com.virtusa.ecommerce.controller..*.*(..))")
	public void logAfterMyMethod(JoinPoint joinPoint) {
		LOG.info("logAfter :: " + joinPoint.getSignature().getName() + "end time ::" + new Date());
	}
	
	
	
	
	
	@Around("execution(* com.virtusa.ecommerce.controller..*.*(..))")
	public Object dd(ProceedingJoinPoint pjp) throws Throwable {
		   long start = System.currentTimeMillis();
        
           Object output = pjp.proceed();
           
           long elapsedTime = System.currentTimeMillis() - start;
         LOG.info("Method execution time: " + elapsedTime + " milliseconds.");
	return output;	
	}

}
