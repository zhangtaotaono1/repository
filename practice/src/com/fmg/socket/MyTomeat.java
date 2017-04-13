package com.fmg.socket;

import java.io.IOException;
import java.io.InputStream;
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
		
//		PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), "gbk"), true);
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		
//		pw.println("<font color='red' size='7' >欢迎查看服务器</font>");
		
		pw.println("HTTP/1.1 200 OK\r\n");
        pw.print("Date: Sat, 31 Dec 2005 23:59:59 GMT\r\n");
        pw.print("Content-Type: text/html;charset=ISO-8859-1\r\n");
        pw.println("Content-Length: 800");
        pw.println("<html><head></head><body><font size='30' color='red'>你好</font></body></html>");
        pw.flush();
		s.close();
		ss.close();
	}
}
