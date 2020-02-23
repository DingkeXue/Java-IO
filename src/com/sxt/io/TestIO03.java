package com.sxt.io;

import java.io.File;

/**
 * ���õݹ麯����ӡ��������File
 * @author Administrator
 *
 */
public class TestIO03 {
	public static void main(String[] args) {
		File rootFile = new File("F:/Eclipse/IO");
		printFile(rootFile);
	}
	
	// ����δ�ӡFile
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
