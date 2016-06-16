package com.cnblogs.yjmyzz.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.number.CurrencyFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormatterTest {

	@Test
	public void testFormatter() {
		
		//设置上下语言的语言环境
		LocaleContextHolder.setLocale(Locale.US);
		
		//--------测试日期格式化----------
		Date d = new Date();
		DateFormatter dateFormatter = new DateFormatter();
		//按中文格式输出日期
		System.out.println(dateFormatter.print(d, Locale.CHINESE));//2014-10-30	
		
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		//添加前面的DateFormatter
		conversionService.addFormatter(dateFormatter);
		
		System.out.println(conversionService.convert(d, String.class));//Oct 30, 2014
		
		dateFormatter.setPattern("yyyy年MM月dd日");		
		System.out.println(conversionService.convert(d, String.class));//2014年10月30日
		
		// --------测试货币格式化-------------
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		BigDecimal money = new BigDecimal(1234567.890);
		System.out.println(currencyFormatter.print(money, Locale.CHINA));//￥1,234,567.89
		conversionService.addFormatter(currencyFormatter);
		System.out.println(conversionService.convert(money, String.class));//$1,234,567.89	
		

	}

}
