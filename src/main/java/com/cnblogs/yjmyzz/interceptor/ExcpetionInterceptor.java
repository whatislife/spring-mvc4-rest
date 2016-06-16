package com.cnblogs.yjmyzz.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExcpetionInterceptor extends HandlerInterceptorAdapter {

	protected Logger logger = LogManager.getLogger();

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("ExcpetionInterceptor.preHandle");
		// 演示：限制仅允许从本机访问
		if (request.getLocalAddr().equals("127.0.0.1")
				|| request.getLocalAddr().equals("0.0.0.0")) {
			return true;
		}
		logger.error("非法入侵：" + request.getLocalAddr());
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("ExcpetionInterceptor.postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("ExcpetionInterceptor.afterCompletion");
		/*if (ex != null) {
			logger.error(handler);
			logger.error(ex.getMessage(), ex);
		}*/
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out
				.println("ExcpetionInterceptor.afterConcurrentHandlingStarted");
	}

}
