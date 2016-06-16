package com.cnblogs.yjmyzz.web.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cnblogs.yjmyzz.consts.AppConsts;
import com.cnblogs.yjmyzz.exception.BusinessException;

@Controller
public class BaseController implements Serializable {

	protected Logger logger = LogManager.getLogger();

	@ExceptionHandler
	public String exp(HttpServletRequest request, Exception ex) {
		String resultViewName = "errors/error";

		// 记录日志
		logger.error(ex.getMessage(), ex);

		// 根据不同错误转向不同页面
		if (ex instanceof BusinessException) {
			resultViewName = "errors/biz-error";
		} else {
			// 异常转换
			ex = new Exception("系统太累了，需要休息!");
		}
		request.setAttribute("ex", ex);

		String xRequestedWith = request.getHeader("X-Requested-With");
		if (!StringUtils.isEmpty(xRequestedWith)) {
			// ajax请求
			resultViewName = "errors/ajax-error";

		}

		return resultViewName;
	}

	private static final long serialVersionUID = -9026704019496520473L;

	private int pageSize = AppConsts.PageSize;

	private int pageIndex = 1;

	private int totalCounts = 0;
	private int totalPages = 0;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalCounts() {
		return totalCounts;
	}

	public void setTotalCounts(int totalCounts) {
		this.totalCounts = totalCounts;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
