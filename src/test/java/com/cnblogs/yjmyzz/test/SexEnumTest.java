package com.cnblogs.yjmyzz.test;

import org.junit.Test;

import com.cnblogs.yjmyzz.enums.SEX;

public class SexEnumTest {

	@Test
	public void testEnum(){		
		SEX man = SEX.Male;		
		System.out.println(man.getValue());
		System.out.println(man.getDescription());
		
		SEX female = SEX.valueOf("Female");
		System.out.println(female.getValue());
		System.out.println(female.getDescription());
		
		SEX unknown = SEX.get("0");
		System.out.println(unknown.getValue());
		System.out.println(unknown.getDescription());
	}
}
