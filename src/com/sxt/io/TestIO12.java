package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 拷贝图片
 * 首先使用文件流处理，在程序中作为中转再写出到字节数组中
 * 文件流 => 程序 => 字节流 => 字节流 => 程序 => 文件流
 * @author Administrator
 *
 */
public class TestIO12 {
	public static void main(String[] args) throws IOException {
		byteArrayToFile(fileToByteArray("F:/Eclipse/IO/a.jpeg"), "F:/Eclipse/IO/b.jpeg");
	}
	
	// 图片转换成字节数组
	public static byte[] fileToByteArray(String path) throws IOException {
		File file = new File(path);
		InputStream inputStream = new FileInputStream(file);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] flush = new byte[1024*10];
		int len = -1;
		while((len = inputStream.read(flush)) != -1) {
			byteArrayOutputStream.write(flush, 0, len);
		}
		inputStream.close();
		return byteArrayOutputStream.toByteArray();
	}
	
	// 字节数组转换成图片
	public static void byteArrayToFile(byte[] arr,String dest) throws IOException {
		File file = new File(dest);
		OutputStream outputStream = new FileOutputStream(file);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arr);
		byte[] flush = new byte[1024];
		int len = -1;
		while((len = byteArrayInputStream.read(flush)) != -1) {
			outputStream.write(flush, 0, len);
			outputStream.flush();
		}
		outputStream.close();
	}
}
