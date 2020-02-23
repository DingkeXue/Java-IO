package com.sxt.io;

import java.io.File;
import java.io.IOException;

/**
 * 测试mkdir mkdirs list listFiles listRoots API
 * @author Administrator
 *
 */
public class TestIO02 {
	public static void main(String[] args) throws IOException {
		// 创建新文件
		File file = new File("aa.txt");
		file.createNewFile();
		
		// mkdir():只有目录都存在时才会创建
		System.out.println("#######################");
		File dirFile = new File("F:/Eclipse/IO/test");
		boolean flag = dirFile.mkdir();
		System.out.println(flag);
		
		// mkdirs():会创建全部目录
		System.out.println("#######################");
		File dirFile2 = new File("F:/Eclipse/IO/dir/test");
		boolean flag2 = dirFile2.mkdirs();
		System.out.println(flag2);
		
		// list():列出下级文件/文件夹名称
		System.out.println("#######################");
		File dirFile3 = new File("F:/Eclipse/IO");
		String[] liStrings = dirFile3.list();
		for(String name:liStrings) {
			System.out.println(name);
		}
		
		// listFile():列出下级所有File对象(完整路径)
		System.out.println("#######################");
		File[] liStrings2 = dirFile3.listFiles();
		for(File file2:liStrings2) {
			System.out.println(file2);
		}
		
		// listRoots():列出下级File对象的绝对路径
		System.out.println("#######################");
		File[] liStrings3 = dirFile3.listFiles();
		for(File file3:liStrings3) {
			System.out.println(file3);
		}
		
		// 删除创建的目录和文件
		file.delete();
		dirFile.delete();
		dirFile2.delete();
	}
}
