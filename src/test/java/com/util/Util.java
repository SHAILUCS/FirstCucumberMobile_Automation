package com.util;

public class Util {
	public static void wait(int num) {
		try {
			Thread.sleep(num*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
