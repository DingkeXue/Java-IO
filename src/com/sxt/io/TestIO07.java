package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *写出文件
 *1.选择源文件
 *2.选择字节流
 *3.操作
 *4.关闭
 * @author Administrator
 *
 */
public class TestIO07 {
	public static void main(String[] args) {
		File file2 = new File("dest.txt");
		outputFile(file2);
	}
	
	public static void outputFile(File file) {
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			String string = "hello world";
			byte[] data = string.getBytes();
			try {
				outputStream.write(data);
				outputStream.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {					
					outputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
