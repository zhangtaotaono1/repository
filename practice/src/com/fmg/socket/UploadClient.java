package com.fmg.socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadClient {

	public static void main(String args[]) throws IOException{
		upload();
	}

	private static void upload() throws IOException {
		Socket s = new Socket("192.168.1.31",6666);
		
		OutputStream os = s.getOutputStream();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Desktop\\图片\\人生，唯有锻炼与读书不能辜负。.jpg");
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while ((len = fis.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
		
		s.shutdownOutput();
		
		InputStream is = s.getInputStream();
		
		byte[] bufStr = new byte[1024];
		int leng = is.read(bufStr);
		String text = new String(bufStr, 0, leng);
		
		System.out.println("text..." + text);
		
		fis.close();
		s.close();
	}
}
