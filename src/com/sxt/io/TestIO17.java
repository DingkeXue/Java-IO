package com.sxt.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ≤‚ ‘ InputStreamReader InputStreamWriter
 * @author Administrator
 * 
 *
 */
public class TestIO17 {
	public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException, IOException {
		reWrite();
	}
	
	public static void reWrite() throws UnsupportedEncodingException, MalformedURLException, IOException {
		BufferedReader bufferedReader = 
				new BufferedReader(
						new InputStreamReader(
								new URL("http://www.baidu.com").openStream(), "UTF-8"));
		BufferedWriter bufferedWriter = 
				new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream("baidu.html"), "UTF-8"));
		String msg;
		while((msg = bufferedReader.readLine()) != null) {
			bufferedWriter.write(msg);
			bufferedWriter.newLine();
		}
		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();

	}
}
