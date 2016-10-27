package com.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TimeLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(TimeLoggingAspect.class);
    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    
    @Before("execution(* com.service.*.*(..))")
    public void logBefore() {
	logger.info("@Before: START " + sdFormat.format( new Date()));
    }

    @Around("execution(* com.service.*.*(..))")
    public void userAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
	logger.info("@Around: Before calculation- " + sdFormat.format( new Date()));
	joinPoint.proceed();
	logger.info("@Around: After calculation-" +  sdFormat.format( new Date()));
    }

    @AfterThrowing(pointcut = "execution(* com.service.*.*(..))", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
	logger.error("@Around: After calculation-" +  sdFormat.format( new Date()));
	logger.error("Exception caught:" + exception.getMessage());
    }
}
