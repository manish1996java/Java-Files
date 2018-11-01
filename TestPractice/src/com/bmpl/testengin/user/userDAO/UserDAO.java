package com.bmpl.testengin.user.userDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bmpl.testengin.utils.CommonDAO;
import com.bmpl.testengin.utils.SQLConstants;

public class UserDAO {
	public static void doLogin(String userid,String password) throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(SQLConstants.LOGIN_QUARY);
			ps.setString(1, userid);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			System.out.println("Query Execute");
			if(rs.next())
			{
				System.out.println("userid :"+rs.getString("userid") +"\t password :"+rs.getString("password"));
			}
		}finally {
			if(rs != null)
			{
				rs.close();
			}
			if(ps != null)
			{
				ps.close();
			}
			if(con != null)
			{
				con.close();
			}
		}
		
	}
	
	public static void doRegister()
	{
		Connection con = null;
		
		con = CommonDAO.getConnection();
		ps = con.prepareStatement("");
		
	}

}
