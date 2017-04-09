package com.fmg.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String args[]) throws IOException {
		out();
		print();
	}

	private static void print() throws IOException {
		Properties pro = new Properties();
		
		FileInputStream file = new FileInputStream("d:\\info.txt");

		pro.load(file);
		pro.list(System.out);
		
		test();
	}

	private static void test() throws IOException {
		File file = new File("d:\\info.txt");
		if(!file.exists()){
			System.out.println("创建文件");
			file.createNewFile();
		}
		
		FileInputStream in = new FileInputStream("d:\\info.txt");
		
		Properties pro = new Properties();
		
		pro.load(in);
		
		pro.setProperty("fmg", "18");
		pro.list(System.out);
		FileOutputStream out = new FileOutputStream("d:\\info.txt");
		
		pro.store(out, "xiugai");
		
		out.close();
		in.close();
	}

	private static void out() throws IOException {
		Properties pro = new Properties();

		pro.setProperty("张桃桃", "18");
		pro.setProperty("冯茂根", "24");
		pro.setProperty("ztt", "18");
		pro.setProperty("fmg", "24");

		FileOutputStream out = new FileOutputStream("d:\\info.txt");
//		pro.storeToXML(out, "name+age", "utf-8");// (out, "name+age");
		pro.store(out, "name+age");// ;

		out.close();
	}
}
