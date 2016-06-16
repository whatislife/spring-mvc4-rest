package com.cnblogs.yjmyzz.test;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;
import com.cnblogs.yjmyzz.util.JaxbUtil;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.XStream;

public class XStreamAndJaxbTest {

	private Sample getSampleObj() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.set(2014, 9, 31, 0, 0, 0);
		Sample obj = new Sample();
		obj.setCreateDate(c.getTime());
		obj.setAmount(1234.5678);
		return obj;
	}

	@Test
	public void testXStream() {		
		XStream x = new XStream();
		x.alias("sample", Sample.class);		
		x.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null,
				TimeZone.getTimeZone("GMT+8")));		
		x.registerConverter(new DoubleToCurrencyStringConverter(Locale.CHINA));
		System.out.println("==> xstream ==>\n");
		System.out.println(x.toXML(getSampleObj()));
		System.out.println("\n\n");
	}

	@Test
	public void testJaxb() {
		System.out.println("==> jaxb ==>\n");
		System.out.println(JaxbUtil.toXml(getSampleObj(),"UTF-8",true));
		System.out.println("\n\n");
	}

}
