package com.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeLoggingAspect {
    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Date current = new Date();
    
    @Before("execution(* com.service.*.*(..))")
    public void logBefore() {
	System.out.println("@Before: STRAT " + sdFormat.format(current));
    }

    @Around("execution(* com.service.*.*(..))")
    public void userAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
	System.out.println("@Around: Before calculation-" +  sdFormat.format(current));
	joinPoint.proceed();
	System.out.println("@Around: After calculation-" +  sdFormat.format(current));
    }

    @AfterThrowing(pointcut = "execution(* com.service.*.*(..))", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
	System.out.println("@AfterReturning:" + sdFormat.format(current));
	System.out.println("Exception caught:" + exception.getMessage());
    }
}
