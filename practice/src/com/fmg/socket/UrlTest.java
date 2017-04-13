package com.fmg.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {

	public static void main(String args[]) throws IOException{
//		urlTest();
		urlDemo();
	}

	private static void urlDemo() throws IOException {
		String str = "http://127.0.0.1:9999/1.html?name=lisi";
		
		URL url = new URL(str);
		
		URLConnection ct = url.openConnection();
		
		System.out.println("URLConnection..." + ct);
		
		String type = ct.getHeaderField("Content-Type");
		System.out.println("type..." + type);
	}

	private static void urlTest() throws IOException {
		String str = "http://127.0.0.1:9999/1.html?name=lisi";
		
		URL url = new URL(str);
		
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getFile());
		System.out.println(url.getPath());
		System.out.println(url.getQuery());
		
		InputStream is = url.openStream();//相当于url.openConnection().getInputStream();
		
		byte[] b = new byte[1024];
		int len = is.read(b);
		String str1 = new String(b, 0, len);
		System.out.println(str1);
	}
}
