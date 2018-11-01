package com.bmpl.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyPaste {
	public static void main(String args[]) throws IOException
	{
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the source path :");
		String srctxt = scan.next();
		
		System.out.println("Enter the destination path :");
		String destxt = scan.next();
		
		
		File scr = new File(srctxt);
		File des = new File(destxt);
		final int EOI = -1;
		
		long startTime = System.currentTimeMillis();
		
		System.out.println("File Reading...");
		FileInputStream fis = new FileInputStream(scr);
		BufferedInputStream bi = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream(des);
		BufferedOutputStream bo = new BufferedOutputStream(fos);
		int singleByte = bi.read();
		
		while(singleByte != EOI)
		{
			bo.write(singleByte);
			singleByte = bi.read();
		}

		bo.close();
		bi.close();
		fos.close();
		fis.close();
		
		System.out.println("File Copied");
		
		long endTime = System.currentTimeMillis();
		System.out.println("process time :"+(endTime-startTime)+" MiliSeconds");
		
	}

}
