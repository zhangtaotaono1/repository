package com.fmg.io;

import java.util.Properties;
import java.util.Set;

public class SystemTest {

	public static void main(String[] args) {
		Properties pro = System.getProperties();
		
		Set<String> keyName = pro.stringPropertyNames();
		
		for (String string : keyName) {
			System.out.println(string + "= " + pro.getProperty(string));
		}
	}
}
