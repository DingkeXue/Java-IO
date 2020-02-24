package com.sxt.io;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 分块思想：RandomAccessFile
 * @author Administrator
 *
 */
public class TestIO20 {
	
	// 文件源
		private File src;
		private String destDir;
		// 文件存储目的地
		private List<String> destPaths;
		// 每块大小
		private int blockSize;
		// 块数
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
			// 计算个数
			this.size = (int)Math.ceil(len / blockSize);
			// 路径
			for (int i = 0; i < this.size; i++) {
				this.destPaths.add(this.destDir + i + "-" + this.src.getName());
			}
		}
		
		// 分块读取
			/**
			 * 1.计算每块的起始位置及大小
			 * 2.分割
			 * @throws IOException 
			 */
			public void split() throws IOException {
				//总长度
				long len = src.length();
				//其实位置和实际大小
				int beginPos = 0;
				int actualSize = (int)(blockSize > len ? len : blockSize);
				
				//每块取值
				for (int i = 0; i < size; i++) {
					beginPos = i * blockSize;
					// 最后一块大小
					if(i == size - 1) {
						actualSize = (int)len;
					} else {
						actualSize = blockSize;
						len -= blockSize * i;
					}
					splitDetail(i, beginPos, actualSize);
				}
				
			}
	
	// 具体读取操作
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
