package com.bmpl.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadDemo {
	
	public static void main(String args[]) throws IOException
	{
		final int EOF = -1;
		File f= new File("E:\\mani.txt");
		if(f.exists())
		{
			FileInputStream fs = new FileInputStream(f);
			int singleByte = fs.read();
//			System.out.println((char)singleByte);
//			singleByte =fs.read();
//			System.out.println((char)singleByte);
//			singleByte =fs.read();
//			System.out.println((char)singleByte);
//			singleByte =fs.read();
//			System.out.println((char)singleByte);
//			singleByte =fs.read();
//			System.out.println((char)singleByte);
//			singleByte =fs.read();
//			System.out.println((char)singleByte);
//			singleByte =fs.read();
//			System.out.println((char)singleByte);
			while(singleByte != EOF) {
				System.out.print((char)singleByte);
				singleByte = fs.read();
			}
			fs.close();
		}
		
		File f2 = new File("E:\\mani.txt");
		System.out.println("\nEnter the text :");
		Scanner scan = new Scanner(System.in);
		String txt = scan.nextLine();
		FileOutputStream fo = new FileOutputStream(f2,true);
		
		fo.write(txt.getBytes());
		fo.close();
		System.out.println("Data write in a file .....");
	}
}
