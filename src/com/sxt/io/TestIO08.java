package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件拷贝：读入和写出
 * @author Administrator
 *
 */
public class TestIO08 {
	public static void main(String[] args) {
		copyFile("test.txt", "dest.txt");
	}
	
	
	public static void copyFile(String src, String dest) {
		File file = new File(src);
		File file2 = new File(dest);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		byte[] flush = new byte[1024];
		int len;
		
		try {
			inputStream = new FileInputStream(file);
			outputStream = new FileOutputStream(file2, true);
			try {
				while((len = inputStream.read(flush)) != -1) {
					System.out.println("读取中---");
					try {
						outputStream.write(flush, 0, flush.length);
						outputStream.flush();
						System.out.println("写入成功！");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
				// 先打开的后关闭
				outputStream.close();
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
