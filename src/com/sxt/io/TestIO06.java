package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读取文件
 * 1.选择源文件 2.选择文件流 3.操作流 4.关闭
 * 文件末尾没字符的的值为-1，空格的值为32
 * @author Administrator
 *
 */
public class TestIO06 {
	public static void main(String[] args) throws IOException {
		// 选择源文件
		File file = new File("F:/Eclipse/IO/test.txt");
		
		// 选择文件流
		InputStream inputStream = new FileInputStream(file);
		int temp;
		// 操作
		while((temp = inputStream.read()) != -1) {
			System.out.print((char) temp);
		}
		// 关闭
		inputStream.close();
		
		readeFile(file);
		
		readFiles(file);
	}
	
	// 逐个字节读出
	public static void readeFile(File file) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			int temp;
			try {
				while((temp = inputStream.read()) != -1) {
					System.out.println(temp);
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
				if (inputStream != null) {
					inputStream.close();					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 分段读入
	public static void readFiles(File file) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			int len = -1;
			byte[] flush = new byte[1024];
			try {
				while((len = inputStream.read(flush)) != -1) {
					String string = new String(flush, 0, len); // 解码
					System.out.println(string);
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
				if (inputStream != null) {
					inputStream.close();					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
