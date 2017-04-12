package com.fmg.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestPro {

	public static void main(String args[]){
		getAbs();
	}

	private static void getAbs() {
		FilenameFilter fileter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith("pdf");
			}
		};
		
		List<File> list = new ArrayList<File>();
		//1、遍历出所有文件
		File file = new File("e:\\桌面\\");
		
		getFile(file, fileter, list);
		
		//2、将指定文件筛选出
		
		//3、读到指定文件
		File destList = new File("pdfList.txt");
		writer2File(list, destList);
	}

	private static void writer2File(List<File> list, File destList) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(destList));
			for (File file : list) {
//				System.out.println(file.getAbsolutePath());
				bw.write(file.getAbsolutePath());
				bw.newLine();
				bw.flush();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw != null){
				try {
					bw.close();
					System.out.println("结束");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static void getFile(File file, FilenameFilter fileter, List<File> list) {
		File[] fileList = file.listFiles();
		
		for (File file2 : fileList) {
			if(file2.isDirectory()){
				getFile(file2, fileter, list);
			}else{
				if(fileter.accept(file, file2.getName())){
					System.out.println(file2);
					list.add(file2);
				}
			}
		}
	}
}
