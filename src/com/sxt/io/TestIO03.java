package com.sxt.io;

import java.io.File;

/**
 * 利用递归函数打印所有子孙File
 * @author Administrator
 *
 */
public class TestIO03 {
	public static void main(String[] args) {
		File rootFile = new File("F:/Eclipse/IO");
		printFile(rootFile);
	}
	
	// 按层次打印File
	public static void printFile(File file) {
		if (file.isFile()) {
			return;
		}
		System.out.println("###################");
		File[] filesStrings = file.listFiles();
		for(File subFile:filesStrings) {
			System.out.println(subFile);
			printFile(subFile);
		}
	}
}
