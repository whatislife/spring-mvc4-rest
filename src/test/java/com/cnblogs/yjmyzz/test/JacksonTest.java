package com.cnblogs.yjmyzz.test;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

import com.cnblogs.yjmyzz.dto.Order;
import com.cnblogs.yjmyzz.util.JacksonUtil;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JacksonTest {

	@Test
	public void testToJson() throws JsonProcessingException {
		Order order = new Order();
		order.setAmount(100);
		order.setClientName("杨俊明");
		order.setCreateTime(new Date());
		order.setId("1");
		System.out.println(JacksonUtil.toJson(order));
	}

	@Test
	public void testToBean() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"id\":\"1\",\"clientName\":\"杨俊明\",\"amount\":100,\"createTime\":1414573133958}";
		System.out.println(JacksonUtil.toObject(json, Order.class));
	}

}
