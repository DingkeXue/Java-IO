package com.sxt.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * 工具的使用
 * @author Administrator
 *
 */
public class TestIO22 {
	public static void main(String[] args) throws IOException {
		long len = FileUtils.sizeOf(new File("F:/Eclipse/IO/src/a.jpeg"));
		System.out.println(len);
		len = FileUtils.sizeOf(new File("F:/Eclipse/IO/src"));
		System.out.println(len);
		
		// 读取文件
		String string = FileUtils.readFileToString(new File("F:/Eclipse/IO/src/com/sxt/io/common.txt"), "UTF-8");
		System.out.println(string);
		
		byte[] arr = FileUtils.readFileToByteArray(new File("F:/Eclipse/IO/src/com/sxt/io/common.txt"));
		System.out.println(arr.length);
		
		// 写入文件
		// FileUtils.write(new File("F:/Eclipse/IO/src/com/sxt/io/common.txt"), "你好世界","GBK",  true);
		
		// 拷贝文件
		FileUtils.writeByteArrayToFile(new File("F:/Eclipse/IO/src/com/sxt/io/common.txt") , arr, true);
		
		// 复制文件
		FileUtils.copyFile(new File("F:/Eclipse/IO/src/a.jpeg"), new File("F:/Eclipse/IO/src/a-copy.jpeg"));
	}
}
