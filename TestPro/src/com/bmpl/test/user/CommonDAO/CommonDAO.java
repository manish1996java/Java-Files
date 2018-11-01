package com.bmpl.test.user.CommonDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDAO {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Connection con = null;
		
		Class.forName("org.postgresql.Driver");
//		System.out.println("Class loaded");
		ResourceBundle rb = ResourceBundle.getBundle("config1");
		con = DriverManager.getConnection(rb.getString("url"),rb.getString("userid"),rb.getString("password"));
//		System.out.println("Connection established");
		
		
		return con;
	}
	

}
