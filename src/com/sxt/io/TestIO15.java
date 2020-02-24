package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 缓冲流 BufferedInputStream  BufferedOutputStream 大小默认是 8K
 * @author Administrator
 * 
 *
 */
public class TestIO15 {
	public static void main(String[] args) throws IOException {
		copyPic("a.jpeg", "a-copy.jpeg");
	}
	
	public static void copyPic(String src, String dest) throws IOException {
		File file = new File(src);
		File file2 = new File(dest);
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		byte[] flush = new byte[1024];
		int len = -1;
		
		inputStream = new BufferedInputStream(new FileInputStream(file));
		outputStream = new BufferedOutputStream(new FileOutputStream(file2));
		while((len = inputStream.read(flush)) != -1) {
			outputStream.write(flush, 0, len);
		}
		inputStream.close();
		outputStream.close();
	}
	
}
