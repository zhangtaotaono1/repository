package com.fmg.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test {
	public static void main(String args[]) {
		
		run();
		
	}

	private static void run(){
		/*try {
			//1、操作数据库的时候；2、连接别的服务器的时候；3、io流
			
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		FileReader fd = null;
		try {
			fd = new FileReader("demo.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				if(fd != null){
					fd.close();
				}
			} catch (IOException e) {
				System.out.println("文件关闭出错");
			}
		}
		
	}
}
