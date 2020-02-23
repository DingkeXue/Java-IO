package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.spi.LocaleNameProvider;

import javax.print.attribute.standard.Destination;
import javax.xml.crypto.Data;

/**
 * �ֽ���������� ByteArrayOutputStream
 * �ֽ����������� ByteArrayInputStream
 * 1. ����Դ���ڲ�ά��
 * 2. ѡ������������Դ
 * 3. ����
 * @author Administrator
 *
 */
public class TestIO10 {
	public static void main(String[] args) throws IOException {
		inputStream();
		outputStream();
		inputOutput();
	}
	
	// ByteArrayInputStream
	public static void inputStream() throws IOException {
		ByteArrayInputStream byteArrayInputStream = null;
		byte[] src = "talk is cheap show me the code".getBytes();
		byteArrayInputStream = new ByteArrayInputStream(src);
		byte[] flush = new byte[1024];
		int len = -1;
		while((len = byteArrayInputStream.read(flush)) != -1) {
			String string = new String(flush);
			System.out.println(string);
		}
	}
	
	// ByteArrayOutputStream
	public static void outputStream() throws IOException {
		ByteArrayOutputStream outputStream = null;
		byte[] src = "talk is cheap show me the code".getBytes();
		outputStream = new ByteArrayOutputStream();
		outputStream.write(src, 0, src.length);
		outputStream.flush();
		System.out.println(outputStream.toByteArray().length);
	}
	
	// ���
	public static void inputOutput() throws IOException {
		ByteArrayInputStream byteArrayInputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		
		byte[] src = "talk is cheap show me the code!".getBytes();
		
		byteArrayInputStream = new ByteArrayInputStream(src);
		byteArrayOutputStream = new ByteArrayOutputStream();
		
		byte[] flush = new byte[1024];
		int len = -1;
		while((len = byteArrayInputStream.read(flush)) != -1) {
			byteArrayOutputStream.write(flush);
			byte[] data = byteArrayOutputStream.toByteArray();
			byteArrayOutputStream.flush();
			// ��ȡ����
			String string = new String(data);
			System.out.println(string);
		}
	}
}
