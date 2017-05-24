package com.fmg.collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		List list = new ArrayList<>();
		
		show(list);
	}

	private static void show(List list) {
		list.add("l1");
		list.add("l2");
		list.add("l3");
		list.add("l4");
		list.add("l5");
		System.out.println(list);
		list.add(0,"l9");
		System.out.println(list);
		
		list.set(1, "c3");
		System.out.println(list);
		
		System.out.println(list.get(0));
		
		System.out.println(list.remove(1));
		
		System.out.println(list);
		System.out.println(list.subList(2, 4));
		
	}
}
