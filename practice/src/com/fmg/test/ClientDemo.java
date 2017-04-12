package com.fmg.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {

	public static void main(String args[]) throws UnknownHostException, IOException{
		client();
	}

	private static void client() throws UnknownHostException, IOException {

		System.out.println("客户端启动...");
		
		Socket s = new Socket("192.168.1.31", 9999);
		
		OutputStream os = s.getOutputStream();
		String str = "嗨，哥们又来了！";
		
		os.write(str.getBytes());
		
		InputStream is = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = is.read(buf);
		str = new String(buf, 0, len);
		System.out.println(str);
		
		s.close();
	}
}
