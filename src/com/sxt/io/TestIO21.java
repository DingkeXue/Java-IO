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
	// �ļ�Դ
	private File srcFile;
	// �ļ��洢Ŀ�ĵ�
	private String dest;
	// �ֿ���
	private int size;
	// ÿ���С
	private int blockSize;
	// �洢��
	private List<String> destPaths;
	
	// ���캯��
	public TestIO21(String src, String dest, int blockSize) {
		this.srcFile = new File(src);
		this.dest = dest;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();
		
		init();
	}
	
	// �����ļ���С�ͷֿ������ļ���
	public void init() {
		// �ļ���С
		long len = this.srcFile.length();
		// �ֿ���
		this.size = (int)Math.ceil(len / blockSize);
		
		// �ļ���
		for (int i = 0; i < this.size; i++) {
			this.destPaths.add(this.dest + i + "-" + this.srcFile.getName());
		}
	}
	
	// �ָ��ļ�:1.����ÿ�����ʼλ�úʹ�С 2.�ֿ��ȡ
	public void split() throws IOException {
		long len = this.srcFile.length();
		// ��ʼλ��
		int begainPos = 0;
		// ÿ�ζ�ȡ��ʵ�ʴ�С
		int acturalSize = (int)(blockSize > len ? len : blockSize);
		
		for (int i = 0; i < this.size; i++) {
			begainPos = i * blockSize;
			// ��������һ��
			if (i == this.size - 1) {
				acturalSize = (int)len;
			} else {
				acturalSize = blockSize;
				len -= acturalSize * i;
			}
			splitDetail(begainPos, i, acturalSize);
		}
	}
	
	// ����ָ�ϸ��
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
	
	// �ļ��ϲ�
	public void merge(String destPath) throws IOException {
		// �����
		OutputStream oStream = new BufferedOutputStream(new FileOutputStream(destPath, true));
		// �������
		Vector<InputStream> vInputStreams = new Vector<InputStream>();
		SequenceInputStream sisInputStream = null;
		for (int i = 0; i < destPaths.size(); i++) {
			vInputStreams.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
		}
		sisInputStream = new SequenceInputStream(vInputStreams.elements());
		// ���� �ֶζ�ȡ
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
