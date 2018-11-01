package com.bmpl.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import com.bmpl.test.utils.CommonConstants;

public class DynamicClassTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		System.out.println("Enter the name of class");
		String name = new Scanner(System.in).next();
		Object object = Class.forName(CommonConstants.PACKAGE_PATH+name).newInstance();
		Method method = object.getClass().getMethod("setVisible",boolean.class);
		method.invoke(object,true);
		
		
		
		
	}

}
