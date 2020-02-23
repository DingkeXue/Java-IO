package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * ¶ÁÈ¡×Ö·û
 * Writer Reader
 * @author Administrator
 *
 */
public class TestIO09 {
	public static void main(String[] args) {
		copyFile("test.txt", "dest.txt");
	}
	
	public static void copyFile(String src, String dest) {
		File file = new File(src);
		File file2 = new File(dest);
		
		Reader reader = null;
		Writer writer = null;
		try {
			reader = new FileReader(file);
			char[] content = new char[1024];
			int len;
			try {
				while((len = reader.read(content)) != -1) {
					writer = new FileWriter(file2);
					writer.write(content);
					System.out.println("1");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {					
					writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (reader != null) {					
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
