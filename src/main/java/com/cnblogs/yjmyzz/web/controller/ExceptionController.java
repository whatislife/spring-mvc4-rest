package com.cnblogs.yjmyzz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cnblogs.yjmyzz.exception.BusinessException;

@Controller
public class ExceptionController extends BaseController {

	private static final long serialVersionUID = -8191260568707495714L;

	@RequestMapping("/common-exception")
	public String commonException() throws Exception {
		throw new Exception("普通异常!");
	}
	
	@RequestMapping("/biz-exception")
	public String bizException() throws Exception {
		throw new BusinessException("业务异常!");
	}

	@RequestMapping("/2b-exception")
	public String exception2b() {
		zeroDiv();
		return null;
	}

	private void zeroDiv() {
		int i = 1 / 0;
		System.out.println(i);
	}

}
