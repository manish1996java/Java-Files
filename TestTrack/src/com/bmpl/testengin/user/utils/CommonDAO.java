package com.bmpl.testengin.user.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDAO {
	
	public static Connection  getConnection() throws SQLException, ClassNotFoundException
	{
		
		Connection con = null;
		ResourceBundle rs =  ResourceBundle.getBundle("config");

		Class.forName(rs.getString("driver"));
//		System.out.println("Class Loaded");
		con =  DriverManager.getConnection(rs.getString("url"),rs.getString("userid"),rs.getString("password"));
//		System.out.println("Connection stablished");
		return con;	
	}
}
