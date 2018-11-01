package com.bmpl.test;
import java.io.File;
import java.io.FilenameFilter;

public class MyFilter {
	
	public static void main(String args[])
	{
		String path = "D:\\";
		File f = new File(path);

		MyFilter4 mf = new MyFilter4();
//		File f1[] = f.listFiles(mf);
		File f1[] = f.listFiles((dir,name)->name.endsWith(".mp4"));
		System.out.println(f1.length);
		
	}
}


class MyFilter4 implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".mp4");
	}
	
}

