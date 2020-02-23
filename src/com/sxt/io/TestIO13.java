package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 图片拷贝
 * 文件流 => 字节流（程序）=> 文件流
 * @author Administrator
 *
 */
public class TestIO13 {
	public static void main(String[] args) throws IOException {
		copyPic("F:/Eclipse/IO/a.jpeg", "F:/Eclipse/IO/cc.jpeg");
	}
	
	public static void copyPic(String path, String dest) throws IOException {
		File file = new File(path);
		File file2 = new File(dest);
		OutputStream outputStream = null;
		InputStream inputStream = null;
		ByteArrayInputStream byteArrayInputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		
		byte[] flush = new byte[1024*10];
		int len = -1;
		byte[] data = new byte[1024*10];
		
		// 图片转换成 byteArray
		inputStream = new FileInputStream(file);
		
		byteArrayOutputStream = new ByteArrayOutputStream();
		while((len = inputStream.read(flush)) != -1) {
			byteArrayOutputStream.write(flush, 0, len);
		}
		data = byteArrayOutputStream.toByteArray();
		
		// byteArray 转换成 图片
		byteArrayInputStream = new ByteArrayInputStream(data);
		outputStream = new FileOutputStream(file2);
		while((len = byteArrayInputStream.read(data)) != -1) {
			outputStream.write(data, 0, len);
			outputStream.flush();
		}
		
		outputStream.close();
		inputStream.close();
	}
}
