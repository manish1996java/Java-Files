package com.bmpl.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import com.bmpl.testengin.user.utils.CommonConstants;
import com.bmpl.testengin.user.utils.CommonUtils;

public class DynamicClassTest {
	
	public static void main(String args[])
	{
		System.out.println("Enter the frame name :");
		Scanner scan = new Scanner(System.in);
		String className = scan.next();
//		String packageName = "com.bmpl.testengin.user.view.";
		
		try {
//				Object object = Class.forName(packageName+className).newInstance();
			Object object = Class.forName(CommonConstants.packageName+className).newInstance();
				Method method = object.getClass().getMethod("setVisible", boolean.class);
				method.invoke(object,true);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}
}
