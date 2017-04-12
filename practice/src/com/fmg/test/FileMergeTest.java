package com.fmg.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class FileMergeTest {

	public static void main(String args[]) throws IOException{
		merge();
	}

	private static void merge() throws IOException {
		Vector<FileInputStream> vt = new Vector<FileInputStream>();
		
		vt.add(new FileInputStream("1.txt"));
		vt.add(new FileInputStream("2.txt"));
		vt.add(new FileInputStream("3.txt"));
		
		Enumeration<FileInputStream> ve = vt.elements();
		
		SequenceInputStream sis = new SequenceInputStream(ve);
		
		FileOutputStream fos = new FileOutputStream("4.txt");
		
		byte[] bye = new byte[1014];
		int len = 0;
		
		while ((len = sis.read(bye)) != -1) {
			fos.write(bye, 0, len);
			
		}
		
		
		fos.close();
		sis.close();
	}
}
