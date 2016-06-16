package com.cnblogs.yjmyzz.test;

import java.text.NumberFormat;
import java.util.Locale;

import com.thoughtworks.xstream.converters.basic.DoubleConverter;

public class DoubleToCurrencyStringConverter extends DoubleConverter {

	NumberFormat format;

	public DoubleToCurrencyStringConverter(Locale local) {
		format = NumberFormat.getCurrencyInstance(local);
	}

	public String toString(Object obj) {
		return format.format(obj);
	}

}
