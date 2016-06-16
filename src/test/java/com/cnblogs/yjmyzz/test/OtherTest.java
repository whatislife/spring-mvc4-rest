package com.cnblogs.yjmyzz.test;

import org.junit.Test;

public class OtherTest {

	@Test
	public void findSkipNumber() {

		String num = "3,6,7,8,9,10,11,12,14";
		int mid = 0;
		String[] zh = num.split(",");

		if (Integer.parseInt(zh[0]) != 1) {
			for (int n = 1; n < Integer.parseInt(zh[0]); n++) {
				System.out.println("----" + n);
			}
		}

		for (int i = 0; i < zh.length - 1; i++) {

			if (Integer.parseInt(zh[i + 1]) - Integer.parseInt(zh[i]) != 1) {
				for (int j = 1; j < Integer.parseInt(zh[i + 1])
						- Integer.parseInt(zh[i]); j++) {
					mid = Integer.parseInt(zh[i]) + j;
					System.out.println("----" + mid);
				}
			}

		}
	}

	@Test
	public void findSkipIndex() {
		String nums = "0,1,1,0,0,1,0,1,0,1,0,0,0";
		String[] arr = nums.split(",");

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].equals("0") && arr[j].equals("1")){
					System.out.println(i);
					break;
				}
			}
		}
	}

}
