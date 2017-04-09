package com.fmg.test;

import java.io.File;
import java.io.FilenameFilter;

public class FileByHidden implements FilenameFilter{

	@Override
	public boolean accept(File arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg0.isHidden();
	}

}
