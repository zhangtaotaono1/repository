package com.fmg.test;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByName implements FilenameFilter {

	
	
	private String name;

	public FilterByName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FilterByName(String name) {
		super();
		this.name = name;
	}

	@Override
	public boolean accept(File arg0, String arg1) {
		return arg1.endsWith(name);
	}

}
