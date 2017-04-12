package com.fmg.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTomeat {

	public static void main(String args[]) throws IOException{
		mytomcat();
	}

	private static void mytomcat() throws IOException {
		ServerSocket ss = new ServerSocket(9999);
		
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = is.read(buf);
		
		String str = new String(buf, 0, len);
		System.out.println(str);
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "gbk"), true);
		
		pw.println("<font color='red' size='7' >欢迎查看服务器</font>");
		s.close();
		ss.close();
	}
}
