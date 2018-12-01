package com.bmpl.sms.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			System.out.println(sdf.format(date));
//			int a = Calendar.DAY_OF_MONTH;
//			System.out.println(a);
			
			

	}

}
