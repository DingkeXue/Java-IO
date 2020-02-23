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
 * ����ͼƬ
 * ����ʹ���ļ��������ڳ�������Ϊ��ת��д�����ֽ�������
 * �ļ��� => ���� => �ֽ��� => �ֽ��� => ���� => �ļ���
 * @author Administrator
 *
 */
public class TestIO12 {
	public static void main(String[] args) throws IOException {
		byteArrayToFile(fileToByteArray("F:/Eclipse/IO/a.jpeg"), "F:/Eclipse/IO/b.jpeg");
	}
	
	// ͼƬת�����ֽ�����
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
	
	// �ֽ�����ת����ͼƬ
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
