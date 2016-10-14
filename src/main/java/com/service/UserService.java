package com.service;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Pointcut(" execution(* com.service.*.*(..))")
    public Integer multiply(int a, int b) {
	int res = a * b;
	System.out.println(a + "*" + b + "= " + res);
	return res;
    }
}
