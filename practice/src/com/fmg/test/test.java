package com.fmg.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.sun.xml.internal.fastinfoset.Decoder;

public class test {
	 public static String hexStr2Str(String hexStr) { 

	        String str = "0123456789ABCDEF";  
	        char[] hexs = hexStr.toCharArray();  
	        byte[] bytes = new byte[hexStr.length() / 2];  
	        int n;  
	        for (int i = 0; i < bytes.length; i++) {  
	            n = str.indexOf(hexs[2 * i]) * 16;  
	            n += str.indexOf(hexs[2 * i + 1]);  
	            bytes[i] = (byte) (n & 0xff);  
	        }  
	        return new String(bytes);  
	    }

	 
	 public static byte[] hexStringToByte(String hex) {
		   int len = (hex.length() / 2);
		   byte[] result = new byte[len];
		   char[] achar = hex.toCharArray();
		   for (int i = 0; i < len; i++) {
		    int pos = i * 2;
		    result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		   }
		   return result;
		  }
		  
		 private static int toByte(char c) {
		    byte b = (byte) "0123456789ABCDEF".indexOf(c);
		    return b;
		 }
	
	public static void main(String args[]) throws UnsupportedEncodingException {
		String str = "e69cace4b9a6e6b3a8e9878de5ae9ee8b7b5e8808ce58f88e6b7b1e585a5e79086e8aebaefbc8ce794b1e6b585e585a5e6b7b1e4b894e8afa6e7bb86e4bb8be7bb8de4ba86";
		
		String	b = hexStr2Str(str);
		
		System.out.println(b);
		
//		URLDecoder.decode(str,"bytes");
//		String str = System.Text.Encoding.UTF8.GetString("\\e5\\8f\\91\\e7\\94\\9f\\e9\\94\\99\\e8\\af\\af\\ef\\bc\\8c\\e8\\af\\b7\\e9\\87\\8d\\e8\\af\\95".ToArray().Select(t => Convert.ToByte(t)).ToArray());
//		System.out.println(str);
		/*Integer a = 0;
		if(null == a || "0".equals(a)){
			System.out.println("111111111111");
		}*/
		/*
//		run();
		try {
			systemIn();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	private static void systemIn() throws IOException {
		InputStream is = System.in;
		
		int ch = is.read();
		System.out.println(ch);
		
		ch = is.read();
		System.out.println(ch);
		
		ch = is.read();
		System.out.println(ch);
		
		ch = is.read();
		System.out.println(ch);
		
		is.close();
		
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
