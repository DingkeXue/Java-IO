package com.sxt.io;

import java.io.File;

/**
 * ������������˼άͳ���ļ��еĴ�С
 * @author Administrator
 *
 */
public class TestIO04 {
	private long length;
	private String path;
	private File scrFile;
	private int count;
	
	public TestIO04(String path) {
		super();
		this.count = 0;
		this.path = path;
		this.scrFile = new File(path);
		getSize(this.scrFile);
	}

	/**
	 * @return the length
	 */
	public long getLength() {
		return length;
	}
	
	public int getCount() {
		return count;
	}

	// ��ȡ�ļ���С
	private void getSize(File file) {
		if (file.isFile()) {
			count++;
			length += file.length();
		} else {
			File[] fileStrings = file.listFiles();
			for(File subFile:fileStrings) {
				getSize(subFile);
			}
		}
	}
	
	public static void main(String[] args) {
		TestIO04 geTestIO04 = new TestIO04("F:/Eclipse/IO");
		System.out.println("�ļ���С��" + geTestIO04.getLength());
		System.out.println("�ļ�������" + geTestIO04.getCount());
		
		TestIO04 geTest = new TestIO04("F:/Eclipse/IO/src");
		System.out.println("�ļ���С��" + geTest.getLength());
		System.out.println("�ļ�������" + geTest.getCount());
	}
}
