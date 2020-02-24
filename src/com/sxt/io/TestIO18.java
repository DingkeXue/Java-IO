package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象流 ObjectInputStream  ObjectOutputStream
 * @author Administrator
 *
 */
public class TestIO18 {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		objectIO();
	}
	
	// 先写出后读入
	public static void objectIO() throws IOException, ClassNotFoundException {
		// 写出
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ObjectOutputStream ooStream = new ObjectOutputStream(
				new BufferedOutputStream(bao));
		ooStream.writeBoolean(false);
		ooStream.writeObject("hello");
		ooStream.flush();
		byte[] data = bao.toByteArray();
		
		// 读入
		ObjectInputStream oiStream = new ObjectInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(data)));
		boolean flag = oiStream.readBoolean();
		Object object = oiStream.readObject();
		
		System.out.println(flag);
		System.out.println(object);
	}
}
