package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TestIO21 {
	// 文件源
	private File srcFile;
	// 文件存储目的地
	private String dest;
	// 分块数
	private int size;
	// 每块大小
	private int blockSize;
	// 存储名
	private List<String> destPaths;
	
	// 构造函数
	public TestIO21(String src, String dest, int blockSize) {
		this.srcFile = new File(src);
		this.dest = dest;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();
		
		init();
	}
	
	// 计算文件大小和分块数、文件名
	public void init() {
		// 文件大小
		long len = this.srcFile.length();
		// 分块数
		this.size = (int)Math.ceil(len / blockSize);
		
		// 文件名
		for (int i = 0; i < this.size; i++) {
			this.destPaths.add(this.dest + i + "-" + this.srcFile.getName());
		}
	}
	
	// 分割文件:1.计算每块的起始位置和大小 2.分块读取
	public void split() throws IOException {
		long len = this.srcFile.length();
		// 起始位置
		int begainPos = 0;
		// 每次读取的实际大小
		int acturalSize = (int)(blockSize > len ? len : blockSize);
		
		for (int i = 0; i < this.size; i++) {
			begainPos = i * blockSize;
			// 如果是最后一块
			if (i == this.size - 1) {
				acturalSize = (int)len;
			} else {
				acturalSize = blockSize;
				len -= acturalSize * i;
			}
			splitDetail(begainPos, i, acturalSize);
		}
	}
	
	// 具体分割细节
	public void splitDetail(int beginPos, int i, int acturalSize) throws IOException {
		RandomAccessFile rAccess = new RandomAccessFile(this.srcFile, "r");
		RandomAccessFile rAccessFile = new RandomAccessFile(this.destPaths.get(i) , "rw");
		
		int len = -1;
		byte[] flush = new byte[1024];
		
		while((len = rAccess.read(flush)) != -1) {
			rAccessFile.write(flush, 0, len);
		}
		
		rAccess.close();
		rAccessFile.close();
	}
	
	// 文件合并
	public void merge(String destPath) throws IOException {
		// 输出流
		OutputStream oStream = new BufferedOutputStream(new FileOutputStream(destPath, true));
		// 输出入流
		Vector<InputStream> vInputStreams = new Vector<InputStream>();
		SequenceInputStream sisInputStream = null;
		for (int i = 0; i < destPaths.size(); i++) {
			vInputStreams.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
		}
		sisInputStream = new SequenceInputStream(vInputStreams.elements());
		// 拷贝 分段读取
		byte[] flush = new byte[1024];
		int len = -1;
		while((len = sisInputStream.read(flush)) != -1) {
			oStream.write(flush);
		}
		oStream.flush();
		oStream.close();
		sisInputStream.close();
	}
	
	public static void main(String[] args) throws IOException {
		TestIO21 testIO21 = new TestIO21("F:\\Eclipse\\IO\\src\\a.jpeg","F:/Eclipse/IO/src/dest/", 1024);
		testIO21.split();
		testIO21.merge("F:/Eclipse/IO/src/dest.jpeg");
	}
}
