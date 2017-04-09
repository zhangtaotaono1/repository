package com.fmg.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {

	public static void main(String args[]) throws IOException{
//		System.out.println(File.separator);
//		getDemo();
//		isDemo();
//		reName(); 
//		lsitsRoot();
//		listName();
//		listDemo();
//		hiddenList();
		File file = new File("d:\\");
		listAll(file, 0);
	}

	private static void listAll(File file, int level) {
		System.out.println(getSpace(level) + file.getAbsolutePath());
		level++;
		
		File[] listFile = file.listFiles();
		if(listFile != null){
			
			for (int i = 0; i < listFile.length; i++) {
				if(listFile[i].isDirectory()){
					listAll(listFile[i], level);
				}
				System.out.println(getSpace(level) + listFile[i].getAbsolutePath());
			}
		}

	}

	private static StringBuffer getSpace(int level) {
		StringBuffer sb = new StringBuffer();
		sb.append("|--");
		for (int i = 0; i < level; i++) {
			sb.append("|");
		}
		return sb;
	}

	private static void hiddenList() {
		File file = new File("c:" + File.separator);
		
		String[] ff = file.list(new FileByHidden());
		
		for (String string : ff) {
			System.out.println(string);
		}
	}

	private static void listDemo() {
		File file = new File("d:" + File.separator);
		
		String[] filter = file.list(new FilterByName("db"));
		for (String string : filter) {
			System.out.println(string);
		}
		
		/*String[] filter = file.list();
		
		for (String string : filter) {
			if(string.endsWith("exe")){
				System.out.println(string);
			}
		}*/
	}

	private static void listName() {
		File f = new File("d:" + File.separator);
		String[] list = f.list();
		
		for (String str : list) {
			System.out.println(str);
		}
	}

	private static void lsitsRoot() {
		File[] files = File.listRoots();
		
		for (File file : files) {
			System.out.println(file);
			System.out.println(file.getFreeSpace());
			System.out.println(file.getTotalSpace());
			System.out.println(file.getUsableSpace());
		}
		
		
	}

	private static void reName() {
		File f1 = new File("201612121837.mp3");
		File f2 = new File("修改.mp3");
		
		boolean b = f1.renameTo(f2);
		
		System.out.println(b);
	}

	private static void isDemo() throws IOException {
		File ff = new File("aaa.txt");
		System.out.println(ff.exists());
		
		if(!ff.exists()){
			ff.createNewFile();
		}
		
		System.out.println(ff.isFile());
		System.out.println(ff.isDirectory());
		
		ff = new File("aa\\bb\\cc");
		if(!ff.exists()){
			ff.mkdirs();
		}
		
		System.out.println(ff.isFile());
		System.out.println(ff.isDirectory());
		
	}

	private static void getDemo() {
		File f1 = new File("a.txt");
		File f2 = new File("C:\\Users\\Administrator\\Desktop\\a.txt");
		
		String f1Path = f1.getPath();
		String f2Path = f2.getPath();
		String absolutePath = f2.getAbsolutePath();
		long length = f2.length();
		long lastModified = f2.lastModified();
		String f1Parent = f1.getParent();
		String f2Parent = f2.getParent();
		
		Date date = new Date(lastModified);
//		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//		String time = df.format(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(date);
		System.out.println("f1Path..." + f1Path);
		System.out.println("f2Path..." + f2Path);
		System.out.println("absolutePath..." + absolutePath);
		System.out.println("length..." + length);
		System.out.println("f1Parent..." + f1Parent);
		System.out.println("f2Parent..." + f2Parent);
		System.out.println("time..." + time);
	}
}
