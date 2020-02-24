package com.sxt.io;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �ֿ�˼�룺RandomAccessFile
 * @author Administrator
 *
 */
public class TestIO20 {
	
	// �ļ�Դ
		private File src;
		private String destDir;
		// �ļ��洢Ŀ�ĵ�
		private List<String> destPaths;
		// ÿ���С
		private int blockSize;
		// ����
		private int size;
		
		public TestIO20(String src, String destDir, int blockSize) {
			// TODO Auto-generated constructor stub
			this.src = new File(src);
			this.destDir = destDir;
			this.blockSize = blockSize;
			this.destPaths = new ArrayList<String>();
			init();
		}
		
		public void init() {
			long len = this.src.length();
			// �������
			this.size = (int)Math.ceil(len / blockSize);
			// ·��
			for (int i = 0; i < this.size; i++) {
				this.destPaths.add(this.destDir + i + "-" + this.src.getName());
			}
		}
		
		// �ֿ��ȡ
			/**
			 * 1.����ÿ�����ʼλ�ü���С
			 * 2.�ָ�
			 * @throws IOException 
			 */
			public void split() throws IOException {
				//�ܳ���
				long len = src.length();
				//��ʵλ�ú�ʵ�ʴ�С
				int beginPos = 0;
				int actualSize = (int)(blockSize > len ? len : blockSize);
				
				//ÿ��ȡֵ
				for (int i = 0; i < size; i++) {
					beginPos = i * blockSize;
					// ���һ���С
					if(i == size - 1) {
						actualSize = (int)len;
					} else {
						actualSize = blockSize;
						len -= blockSize * i;
					}
					splitDetail(i, beginPos, actualSize);
				}
				
			}
	
	// �����ȡ����
	public void splitDetail(int i,int beginPos, int size) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(this.src, "r");
		RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i), "rw");
		byte[] flush = new byte[1024];
		raf.seek(beginPos);
		int len = -1;
		
		while((len = raf.read(flush)) != -1) {
			raf2.write(flush, 0, len);
		}
		raf2.close();
		raf.close();
	}
	
	public static void main(String[] args) throws IOException {
		TestIO20 splitIo20 = new TestIO20("F:/Eclipse/IO/src/a.jpeg", "F:/Eclipse/IO/src", 1024);
		splitIo20.split();
	}
}
