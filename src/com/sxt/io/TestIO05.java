package com.sxt.io;

import java.io.UnsupportedEncodingException;

/**
 * 编码与解码的问题
 * 编码：字符串 => 字节码
 * 解码: 字节码 => 字符串
 * @author Administrator
 *
 */
public class TestIO05 {
	public static void main(String[] args) {
		//  编码
		String msgString = "吉林大学";
		byte[] arr = msgString.getBytes();// 默认和编辑器编码一致（GBK）
		System.out.println(arr.length); // 8
		
		// 解码
		String decodeString = new String(arr);
		System.out.println(decodeString); // 吉林大学
		
		// 乱码问题：1.字符码少了  2.解码与编码规则不对称
		String deString = new String(arr, 0, arr.length - 1);
		System.out.println(deString); // 乱码：吉林大?
		
		try {
			String deString2 = new String(arr, "UTF-8");
			System.out.println(deString2); //乱码： ??????
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
