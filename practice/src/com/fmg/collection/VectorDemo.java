package com.fmg.collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		Vector vc = new Vector<>();
		
		vc.addElement("v1");
		vc.addElement("v2");
		vc.addElement("v3");
		vc.addElement("v4");
		
		System.out.println(vc);
		
		Enumeration v = vc.elements();
		
		while(v.hasMoreElements()){
			System.out.println("Enumeration:" + v.nextElement());
		}
		
		Iterator v1 = vc.iterator();
		
		while(v1.hasNext()){
			System.out.println("next:" + v1.next());
		}
	}
}
