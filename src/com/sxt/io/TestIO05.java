package com.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * ��������������
 * ���룺�ַ��� => �ֽ���
 * ����: �ֽ��� => �ַ���
 * @author Administrator
 *
 */
public class TestIO05 {
	public static void main(String[] args) {
		//  ����
		String msgString = "���ִ�ѧ";
		byte[] arr = msgString.getBytes();// Ĭ�Ϻͱ༭������һ�£�GBK��
		System.out.println(arr.length); // 8
		
		// ����
		String decodeString = new String(arr);
		System.out.println(decodeString); // ���ִ�ѧ
		
		// �������⣺1.�ַ�������  2.�����������򲻶Գ�
		String deString = new String(arr, 0, arr.length - 1);
		System.out.println(deString); // ���룺���ִ�?
		
		try {
			String deString2 = new String(arr, "UTF-8");
			System.out.println(deString2); //���룺 ??????
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
