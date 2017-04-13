package com.fmg.socket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {

	public static void main(String args[]) throws IOException{
		uploadServer();
	}

	private static void uploadServer() throws IOException {
		ServerSocket ss = new ServerSocket(6666);
		Socket s = ss.accept();
		
		File file = new File("d:\\demo");
		if(!file.exists()){
			file.mkdirs();
		}
		InputStream is = s.getInputStream();
		
		File file1 = new File(file, s.getInetAddress().getHostAddress()+".jpg");
		
		FileOutputStream fos = new FileOutputStream(file1);
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = is.read(buf)) != -1){
			fos.write(buf, 0, len);
		}
		
		OutputStream os = s.getOutputStream();
		
		os.write("上传成功".getBytes());
		
		fos.close();
		s.close();
		ss.close();
	}
}
