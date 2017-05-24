package com.fmg.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {

	public static void main(String[] args) {
//		Collection coll = new ArrayList<>();
//		
//		show(coll);
//		
//		Collection c1 = new ArrayList<>();
//		Collection c2 = new ArrayList<>();
//		
//		show(c1, c2);
		
		Collection coll = new ArrayList<>();
		coll.add("a1");
		coll.add("a2");
		coll.add("a3");
		coll.add("a4");
		
		System.out.println(coll);
		
		Iterator it = coll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
		for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
			
		}
	}

	private static void show(Collection c1, Collection c2) {
		c1.add("c1");
		c1.add("c2");
		c1.add("c3");
		c1.add("c4");
		System.out.println("c1"+c1);
		
		c2.add("c2");
		c2.add("c8");
		c2.add("c9");
		System.out.println("c2"+c2);
		
//		c1.addAll(c2);
//		System.out.println("c1" + c1);
//		
//		c1.removeAll(c2);
//		System.out.println("c1" + c1);
		
		System.out.println("c1.contains.c2" + c1.contains(c2));
		c1.retainAll(c2);
		System.out.println("c1.retainAll.c2" + c1);
		

	}

	private static void show(Collection coll) {
		coll.add("a1");
		coll.add("a2");
		coll.add("a3");
		coll.add("a1");
		System.out.println("coll" + coll);
		
		coll.remove("a2");
		System.out.println("coll" + coll);
		
		coll.clear();
		System.out.println("coll" + coll);
		
	}
}
