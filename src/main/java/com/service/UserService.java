package com.service;

import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Pointcut(" execution(* com.service.*.*(..))")
    public Integer multiply(int a, int b) {
	int res = a * b;
	logger.info("a :" + Integer.toString(a));
	logger.info("b :" + Integer.toString(b));
//	System.out.println(a + "*" + b + "= " + res);
	return res;
    }
}
