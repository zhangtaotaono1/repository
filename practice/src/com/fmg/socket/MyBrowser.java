package com.fmg.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MyBrowser {

	public static void main(String args[]) throws IOException{
		myBrowser();
	}

	private static void myBrowser() throws IOException {

		String ip = InetAddress.getLocalHost().getHostAddress();
		System.out.println("ip..." + ip);
		Socket s = new Socket(ip,9999);
		
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		
		out.println("GET /1.html HTTP/1.1");
		out.println("Accept: */*");
		out.println("Host:" + ip);
		out.print("Connection:colse");
		out.println();
		out.println();
		
		InputStream is = s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = is.read(buf);
		
		String text = new String(buf, 0, len);
		
		System.out.println(text);
		
		s.close();
	}
}
