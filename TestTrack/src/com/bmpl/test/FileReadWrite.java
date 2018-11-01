package com.bmpl.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWrite {
	
	public static void main(String args[]) throws IOException
	{
		
		final int EOI = -1;
		File scr = new File("E:\\vicky.txt");
		
		if(!scr.exists())
			{
			scr.createNewFile();
			System.out.println("File created");
			}
		
//		if(scr.exists())
//		{
//			scr.delete();
//			System.out.println("File deleted");
//		}
//		else
//		{
//			scr.createNewFile();
//			System.out.println("Folder created");
//		}
		
		if(scr != null)
		{
		FileReader fr = new FileReader(scr);
		int singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
//		
//		singleByte = fr.read();
//		System.out.println((char)singleByte);
		
		while(singleByte != EOI)
		{
			System.out.print((char)singleByte);
			singleByte = fr.read();
		}
		fr.close();
		}
		
		
		FileWriter fw = new FileWriter(scr,true);
		
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter the text :");
		String txt = scan.nextLine();
		
		fw.write(txt);
		fw.close();
		
	}

}
