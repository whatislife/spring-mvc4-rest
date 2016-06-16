package com.cnblogs.yjmyzz.repository;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.cnblogs.yjmyzz.enums.SEX;

public class EnumRepository {
	static Map<String, String> sexMap = null;

	public static Map<String, String> getSexMap() {
		if (sexMap == null) {
			sexMap = new HashMap<String, String>();
			EnumSet<SEX> sexs = EnumSet.allOf(SEX.class);
			for (SEX sex : sexs) {
				sexMap.put(sex.getValue(), sex.getDescription());
			}
		}
		return sexMap;
	}

}
