package com.sxt.io;

import java.io.File;
import java.io.IOException;

/**
 * ����mkdir mkdirs list listFiles listRoots API
 * @author Administrator
 *
 */
public class TestIO02 {
	public static void main(String[] args) throws IOException {
		// �������ļ�
		File file = new File("aa.txt");
		file.createNewFile();
		
		// mkdir():ֻ��Ŀ¼������ʱ�Żᴴ��
		System.out.println("#######################");
		File dirFile = new File("F:/Eclipse/IO/test");
		boolean flag = dirFile.mkdir();
		System.out.println(flag);
		
		// mkdirs():�ᴴ��ȫ��Ŀ¼
		System.out.println("#######################");
		File dirFile2 = new File("F:/Eclipse/IO/dir/test");
		boolean flag2 = dirFile2.mkdirs();
		System.out.println(flag2);
		
		// list():�г��¼��ļ�/�ļ�������
		System.out.println("#######################");
		File dirFile3 = new File("F:/Eclipse/IO");
		String[] liStrings = dirFile3.list();
		for(String name:liStrings) {
			System.out.println(name);
		}
		
		// listFile():�г��¼�����File����(����·��)
		System.out.println("#######################");
		File[] liStrings2 = dirFile3.listFiles();
		for(File file2:liStrings2) {
			System.out.println(file2);
		}
		
		// listRoots():�г��¼�File����ľ���·��
		System.out.println("#######################");
		File[] liStrings3 = dirFile3.listFiles();
		for(File file3:liStrings3) {
			System.out.println(file3);
		}
		
		// ɾ��������Ŀ¼���ļ�
		file.delete();
		dirFile.delete();
		dirFile2.delete();
	}
}
