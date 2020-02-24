package com.sxt.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * ´òÓ¡Á÷ PrintStream PrintWriter
 * @author Administrator
 *
 */
public class TestIO19 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream pStream = System.out;
		pStream.print("a");
		
		PrintStream pStream2 = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")));
		pStream2.println("hello");
		pStream2.println("world");
		pStream2.close();
		
		
		PrintWriter pWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream("print-writer.txt")));
		pWriter.print("hello");
		pWriter.print("world");
		pWriter.close();
	}
}
