package com.bmpl.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileFilter1 {
	
	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		File f = new File("D:\\emp.dat");
		
		Emp em = new Emp();
		Emp kk;
//		FileInputStream fis = new FileInputStream(f);
//		ObjectInputStream oi = new ObjectInputStream(fis);
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oo = new ObjectOutputStream(fos);
		oo.writeObject(em);
		
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream oi = new ObjectInputStream(fis);
		kk = (Emp)oi.readObject();
		System.out.println("getId"+kk.getEmpId()+"\n getName"+kk.getEmpName()+"\n getSalary"+kk.getSalary());
		
		
		
		
		
	}

}
