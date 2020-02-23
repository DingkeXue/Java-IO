package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *д���ļ�
 *1.ѡ��Դ�ļ�
 *2.ѡ���ֽ���
 *3.����
 *4.�ر�
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
