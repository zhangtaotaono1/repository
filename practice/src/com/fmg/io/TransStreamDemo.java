package com.fmg.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TransStreamDemo {

	public static void main(String args[]) throws IOException{
		demo();
	}

	private static boolean demo() throws IOException {
		FileReader fis = null;
		try {
			fis = new FileReader("a.txt");
		} catch (FileNotFoundException e) {
			
			System.out.println("文件不存在");
			return false;
		}
		
		if(!fis.ready()){
			System.out.println("信息不存在");
			return false;
		}
		
		FileWriter fw = new FileWriter("b.txt");
		BufferedReader br = new BufferedReader(fis);
		BufferedWriter buf = new BufferedWriter(fw);
		String len=null;
		while((len=br.readLine())!=null){
			buf.write(len);
			buf.flush();
		}
		
		buf.close();
		br.close();
		/*File file = new File("a.txt");
		if(!file.exists()){
			System.out.println("这个文件不存在！！！");
			return false;
		}
		if(!file.isFile()){
			System.out.println("这不是一个文件！！");
			return false;
		}*/
		
		System.out.println("结束...");
		return true;
	}
}
