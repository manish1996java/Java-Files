package com.bmpl.testengin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CommonDAO {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
	Connection con=null;
	ResourceBundle rb = ResourceBundle.getBundle("config");
	
	Class.forName(rb.getString("driver"));
	System.out.println("Class is loaded");
	
	con= DriverManager.getConnection(rb.getString("url"),rb.getString("userid"),rb.getString("password"));
	if(con!=null)
	{
		System.out.println("Connection Established");
	}
	
	return con;
	}

}