package com.fmg.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String args[]) throws IOException{
		
		server();
	}

	private static void server() throws IOException {
		
		System.out.println("服务端启动...");
		ServerSocket ss = new ServerSocket(9999);
		
		Socket info = ss.accept();
		String ip = info.getInetAddress().getHostAddress();
		InputStream is = info.getInputStream();
		
		byte[] be = new byte[1024];
		
		int len = is.read(be);
		String str = new String(be, 0, len);
		
		System.out.println(ip + "..." + str);
		
		OutputStream os = info.getOutputStream();
		os.write("收到".getBytes());
		
		info.close();
		ss.close();
	}
}
