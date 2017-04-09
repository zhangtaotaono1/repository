package com.fmg.test;

import java.io.IOException;
import java.io.InputStream;

public class ReadKey {

	public static void main(String atgs[]) throws IOException{
//		char s = '\r';
//		System.out.println(s);
		readKey();
	}

	/**
	 * @throws IOException 
	 * @Title: readKey 
	 * @Description: 判断输入的是否为over，是则停止，不是则打印出来继续
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	private static void readKey() throws IOException {
		//1、加载容易
		StringBuffer sb = new StringBuffer();
		
		//2、获取键盘输入流
		InputStream si = System.in;
		
		//3、定义变量纪录读取到的字节，并循环获取
		int ch = 0;
		
		while((ch = si.read()) != -1) {
			if(ch == '\r'){
				continue;
			}
			if(ch == '\n'){
				String temp = sb.toString();
				if("over".equals(temp)){
					break;
				}
				System.out.println(temp.toUpperCase());
				sb.delete(0, sb.length());
			}else{
				sb.append((char)ch);
			}
		}
	}
}
