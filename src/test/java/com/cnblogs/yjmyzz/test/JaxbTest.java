package com.cnblogs.yjmyzz.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import com.cnblogs.yjmyzz.dto.Order;
import com.cnblogs.yjmyzz.util.JaxbUtil;

public class JaxbTest {

	public static String utc2Local(String utcTime, String utcTimePatten,
			String localTimePatten) {
		SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten);
		utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date gpsUTCDate = null;
		try {
			gpsUTCDate = utcFormater.parse(utcTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat localFormater = new SimpleDateFormat(localTimePatten);
		localFormater.setTimeZone(TimeZone.getDefault());
		String localTime = localFormater.format(gpsUTCDate.getTime());
		return localTime;
	}

	public void testUTC() {

	}

	@Test
	public void testToXml() {
		Order order = new Order();
		order.setAmount(100);
		order.setClientName("杨俊明");
		order.setCreateTime(new Date());
		order.setId("1");
		System.out.println(JaxbUtil.toXml(order));
	}

	@Test
	public void testToBean() {
		String xml = "<order><amount>99</amount><clientName>Z</clientName><createTime>2014-10-24T13:33:54+08:00</createTime></order>";
		System.out.println(JaxbUtil.toObject(xml, Order.class));
	}

}
