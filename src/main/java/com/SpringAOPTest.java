package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.service.UserService;

public class SpringAOPTest {
    public static void main(String[] args) {
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.register(AspectConfig.class);
	ctx.refresh();
	UserService userService = ctx.getBean(UserService.class);
	userService.multiply(5, 10);
    }
}
