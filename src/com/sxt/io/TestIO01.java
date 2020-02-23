package com.sxt.io;

import java.io.File;
import java.io.IOException;

/**
 * ²âÊÔIO
 * @author Administrator
 *
 */
public class TestIO01 {
	public static void main(String[] args) throws IOException {
		File file = new File("test.txt");
		if (file.exists()) {
			System.out.println("1");
			System.out.println("#################");
			System.out.println(file.getAbsolutePath());
			System.out.println("#################");
			System.out.println(file.getPath());
			System.out.println("#################");
			System.out.println(file.getParent());
			System.out.println("#################");
			System.out.println(file.getName());
			System.out.println("#################");
			if (file.isFile()) {
				System.out.println(file.length());
				file.delete();
			} else {
				System.out.println("ÎÄ¼þ¼Ð");
			}
		} else {
			Boolean flag = file.createNewFile();
			System.out.println(flag);
			
		}
	}
}
