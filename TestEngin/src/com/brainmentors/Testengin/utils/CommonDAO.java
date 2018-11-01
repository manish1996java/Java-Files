package com.brainmentors.Testengin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
public interface CommonDAO {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		System.out.println("start getting Connection ");
		Connection con=null;
		ResourceBundle rb= ResourceBundle.getBundle("config");
		
		Class.forName(rb.getString("driver"));
		System.out.println("Class is loaded");
		con = DriverManager.getConnection(rb.getString("url"), rb.getString("userid"), rb.getString("password"));
		System.out.println("Connection Established");
		return con;
	}

}
