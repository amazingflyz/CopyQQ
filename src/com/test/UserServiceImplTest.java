package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qq.model.User;
import com.qq.service.UserService;

import junit.framework.TestCase;

public class UserServiceImplTest extends TestCase {
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	UserService us = ac.getBean(UserService.class);
	User obj = new User();
	public void testLogin() {
		String str = "[{\"oo\":\"617005555\",\"pwd\":\"123456\"}]";
		System.out.println(us.login(str));
		
		
	}

	public void testRegister() {
		fail("Not yet implemented");
	}

}
