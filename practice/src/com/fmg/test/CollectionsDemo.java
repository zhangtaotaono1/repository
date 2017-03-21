package com.fmg.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

	public static void main(String[] args) {
		
		demo1();
	}

	private static void demo1() {
		List<String> list = new ArrayList<String>();
		
		list.add("a");
		list.add("wer");
		list.add("fd");
		list.add("dfs");
		list.add("z");
		
		
		//排序
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		//查找位置
		int index = Collections.binarySearch(list, "fd");
		System.out.println(index);
		
		//替换
		Collections.replaceAll(list, "z", "abc");
		System.out.println(list);
		
		//随机排序
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}
}
