package com.cnblogs.yjmyzz.convertor;

import org.springframework.core.convert.converter.Converter;
import com.cnblogs.yjmyzz.enums.SEX;

public class String2SexConvertor implements Converter<String, SEX> {

	@Override
	public SEX convert(String enumValueStr) {
		String value = enumValueStr.trim();
		if (value.isEmpty()) {
			return null;
		}
		return SEX.get(enumValueStr);
	}
}
