package com.bmpl.testengin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDAO {
	
	static public Connection getConnection() throws SQLException, ClassNotFoundException {
		
		ResourceBundle rs = ResourceBundle.getBundle("config1");
		System.out.println("Bundle load");
		
		Class.forName("org.postgresql.Driver");
		System.out.println("Class loaded");
		Connection con = null;
		
		con = DriverManager.getConnection(rs.getString("url"),rs.getString("userid"),rs.getString("password"));
		System.out.println("Connection Established");
		return con;
	}

}
