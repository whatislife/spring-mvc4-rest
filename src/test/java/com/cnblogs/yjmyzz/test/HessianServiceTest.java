package com.cnblogs.yjmyzz.test;
import java.net.MalformedURLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnblogs.yjmyzz.service.hessian.HelloService;

public class HessianServiceTest {	
	@SuppressWarnings("resource")
	@Test
	public void testService() throws MalformedURLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"hessian-client.xml");
		HelloService hello = (HelloService) context.getBean("hessianClient");
		System.out.println(hello.helloWorld("jimmy.yang"));
	}
}
