package com.cnblogs.yjmyzz.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cnblogs.yjmyzz.convertor.OrderConverter;
import com.cnblogs.yjmyzz.dto.Order;
import com.cnblogs.yjmyzz.dto.OrderList;
import com.cnblogs.yjmyzz.entity.TOrder;
import com.cnblogs.yjmyzz.repository.EnumRepository;
import com.cnblogs.yjmyzz.service.OrderService;
import com.cnblogs.yjmyzz.util.JacksonUtil;
import com.cnblogs.yjmyzz.util.JaxbUtil;
import com.cnblogs.yjmyzz.util.ResponseUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@RequestMapping("/rest/orders")
@Controller
public class OrdersController extends BaseController {

	private static final long serialVersionUID = -4502088918359509675L;

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "list/{pageIndex}")
	public ModelAndView list(@PathVariable int pageIndex,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LocaleContextHolder.setLocale(Locale.CHINA);//强制指定成中文环境
		ModelAndView model = new ModelAndView();
		PageList<TOrder> entities = orderService.getAll(pageIndex,
				getPageSize());
		OrderList orderList = new OrderList();
		List<Order> orders = new ArrayList<Order>();
		for (TOrder entity : entities) {
			orders.add(OrderConverter.toDto(entity));
		}
		orderList.setOrders(orders);
		model.addObject("data", orderList);
		model.addObject("pageSize", entities.getPaginator().getLimit());
		model.addObject("totalCounts", entities.getPaginator().getTotalCount());
		model.addObject("totalPages", entities.getPaginator().getTotalPages());
		model.addObject("pageIndex", entities.getPaginator().getPage());
		model.setViewName("orders/list");
		return model;
	}

	@RequestMapping(value = "show/{id}")
	public ModelAndView show(@PathVariable int id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LocaleContextHolder.setLocale(Locale.CHINA);//强制指定成中文环境
		ModelAndView model = new ModelAndView();
		Order order = orderService.get(id + "");
		model.addObject("data", order);		
		model.setViewName("orders/show");
		return model;
	}

	@RequestMapping(value = "create")
	public ModelAndView create(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView();
		model.addObject("data", new Order());
		model.addObject("sexMap", EnumRepository.getSexMap());
		model.setViewName("orders/create");
		return model;
	}

	@RequestMapping(value = "edit/{id}")
	public ModelAndView edit(@PathVariable int id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView();
		Order order = orderService.get(id + "");
		model.addObject("sexMap", EnumRepository.getSexMap());//枚举列表,便于页面绑定
		model.addObject("data", order);
		model.setViewName("orders/edit");
		return model;
	}

	@RequestMapping(value = "deleteConfirm/{id}")
	public ModelAndView deleteConfirm(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView model = new ModelAndView();
		Order order = orderService.get(id + "");
		model.addObject("data", order);
		model.setViewName("orders/deleteConfirm");
		return model;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		orderService.doRemove(id + "");
		response.sendRedirect("../list/1");
		return null;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response, Order data, @RequestBody String body)
			throws Exception {
		String contentType = request.getHeader("content-type").toLowerCase();

		if (contentType.equals(MediaType.APPLICATION_XML_VALUE)) {
			data = JaxbUtil.toObject(body, Order.class);
		} else if (contentType.equals(MediaType.APPLICATION_JSON_VALUE)) {
			data = JacksonUtil.toObject(body, Order.class);
		}

		ModelAndView model = new ModelAndView();
		orderService.doSave(data);

		if (contentType.equals(MediaType.APPLICATION_XML_VALUE)) {
			response.sendRedirect("show/" + data.getId() + ".xml");
			return null;
		} else if (contentType.equals(MediaType.APPLICATION_JSON_VALUE)) {
			response.sendRedirect("show/" + data.getId() + ".json");
			return null;
		} else {
			model.addObject("data", data);
			model.setViewName("orders/show");
			return model;
		}

	}

	@RequestMapping(value = "writeHtml")
	public String writeHtml(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ResponseUtil.OutputHtml(response,
				"<h1 style='color:red'>Hello World!</h1>");
		return null;

	}

	@RequestMapping(value = "writeXml")
	public String writeXml(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ResponseUtil.OutputXml(response,
				"<data><message>Hello World!</message></data>");
		return null;
	}

	@RequestMapping(value = "writeJson")
	public String writeJson(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ResponseUtil.OutputJson(response, "{'message':'Hello World'}");
		return null;
	}

	@RequestMapping(value = "writeImage")
	public String writeImage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ResponseUtil.OutputImage(response);
		return null;
	}

}
