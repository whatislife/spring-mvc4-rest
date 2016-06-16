package com.cnblogs.yjmyzz.web.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends BaseController {

	private static final long serialVersionUID = 3773067665750765806L;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

}
