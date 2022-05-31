package com.util;

import java.io.FileReader;
import java.util.Properties;

public class Prop {
	public static synchronized String getProp(String key) {
		try {
			FileReader reader = new FileReader("config.properties");
			Properties p = new Properties();
			p.load(reader);
			return (String) p.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ERROR";
	}
}
