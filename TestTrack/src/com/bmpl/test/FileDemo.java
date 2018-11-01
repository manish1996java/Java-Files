package com.bmpl.test;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	public static void main(String args[]) throws IOException
	{
		String path="E:\\manish\\priya\\vikrant\\keshav\\kapil";
		File f= new File(path);
		if(!f.exists())
		{
			f.mkdirs();
			System.out.println("directories created");
		}
		

		String path2=path+"\\mk.txt";
		File f2= new File(path2);
		if(f.exists())
		{
			
			if(f2.exists())
			{
				f2.delete();
				System.out.println("File deleted");
					
			}
			else
			{
			f2.createNewFile();
			System.out.println("File is created");
			}
		}
		
	}

}
