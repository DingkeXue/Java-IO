package com.sxt.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * ²âÊÔ×Ö½Ú»º³å BufferedReader BufferedWriter
 * @author Administrator
 *
 */
public class TestIO16 {
	public static void main(String[] args) throws IOException {
		copyTxt("test.txt", "test-copy.txt");
	}

	public static void copyTxt(String scr, String dest) throws IOException {
		File file = new File(scr);
		File file2 = new File(dest);
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter bsWriter = new BufferedWriter(new FileWriter(file2));
		
		String line = null;
		while((line = reader.readLine()) != null) {
			bsWriter.write(line);
			bsWriter.newLine();
		}
		reader.close();
		bsWriter.close();
	}
}
