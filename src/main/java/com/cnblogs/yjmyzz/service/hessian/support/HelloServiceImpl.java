package com.cnblogs.yjmyzz.service.hessian.support;

import com.cnblogs.yjmyzz.service.hessian.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String helloWorld(String message) {
		return "hello," + message;
	}

}
