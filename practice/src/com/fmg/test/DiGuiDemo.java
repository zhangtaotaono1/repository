package com.fmg.test;

import java.io.File;
import java.io.IOException;

public class DiGuiDemo {

	public static void main(String args[]) throws IOException{
//		toBin(6);
//		System.out.println(getSum(10));
//		mkdir();
		File file = new File("d:\\demo");
		delet(file);
	}


	private static void delet(File file) {
		File[] ff = file.listFiles();
		for (File file2 : ff) {
			
			if(file2.isDirectory()){
				delet(file2);
			}else{
				System.out.println(file2.delete());
			}
		}
		System.out.println(file.delete());
		
	}


	private static void mkdir() throws IOException {
		File file = new File("d:\\demo\\aa\\bb\\cc");
		
		if(!file.isDirectory()){
			file.mkdirs();
		}
	}


	private static int getSum(int i) {
		if(i == 1){
			return 1;
		}
		return i + getSum(i-1);
	}


	private static void toBin(int num) {
		if(num > 0){
			toBin(num/2);
			System.out.print(num%2);
		}
		
	}
}
