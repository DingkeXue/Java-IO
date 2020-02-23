package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * ��ȡ�ļ�
 * 1.ѡ��Դ�ļ� 2.ѡ���ļ��� 3.������ 4.�ر�
 * �ļ�ĩβû�ַ��ĵ�ֵΪ-1���ո��ֵΪ32
 * @author Administrator
 *
 */
public class TestIO06 {
	public static void main(String[] args) throws IOException {
		// ѡ��Դ�ļ�
		File file = new File("F:/Eclipse/IO/test.txt");
		
		// ѡ���ļ���
		InputStream inputStream = new FileInputStream(file);
		int temp;
		// ����
		while((temp = inputStream.read()) != -1) {
			System.out.print((char) temp);
		}
		// �ر�
		inputStream.close();
		
		readeFile(file);
		
		readFiles(file);
	}
	
	// ����ֽڶ���
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
	
	// �ֶζ���
	public static void readFiles(File file) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			int len = -1;
			byte[] flush = new byte[1024];
			try {
				while((len = inputStream.read(flush)) != -1) {
					String string = new String(flush, 0, len); // ����
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
