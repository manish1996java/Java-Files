package com.brainmentors.Testengin.user.UserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.brainmentors.Testengin.utils.CommonDAO;

public class UserDAO {
	
	public String doLogin(String userid,String password) throws ClassNotFoundException, SQLException
	{
		System.out.println("Enter in doLogin");
		Connection con =  null;
		PreparedStatement ps= null;
		ResultSet rs= null;
		String message="Invalid userid and password";
		
		try {
		
		con= CommonDAO.getConnection();
		
		ps = con.prepareStatement("select userid,password from user_mst where userid=? and password=?;");
		
		ps.setString(1, userid);
		ps.setString(2, password );
		rs = ps.executeQuery();
		
		
		if(rs.next())
		{
			message="Welcome"+userid;
		}
		}finally {
			if(rs!=null)
			{
				rs.close();
			}
			if(ps!=null)
			{
				ps.close();
			}
			if(con!=null)
			{
				con.close();
			}
		}
		
		return message;
	}}

//	public static void main(String args[])
//	{
//		
//		Connection con=null;
//		PreparedStatement ps= null;
//		ResultSet rs=null;
//		try {
//			ResourceBundle rb= ResourceBundle.getBundle("config");
//			
////			Class.forName("org.postgresql.Driver");
//			Class.forName(rb.getString("driver"));
//			System.out.println("Driver is loaded");
//		
//		
////			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/testengin","postgres","manish");
//			con=DriverManager.getConnection(rb.getString("url"), rb.getString("userid"), rb.getString("password"));
//			if(con!=null)
//			{
//				System.out.println("Connection establised");
//			}
//			ps=con.prepareStatement("Select * from test");
//			rs=ps.executeQuery();
//			
//			while(rs.next())
//			{
//				System.out.println("Name :"+rs.getString("name")+"  Password :"+rs.getString("password"));
//			}
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Please Contact Software Admin");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("DB level problem");
//		}  catch (Exception e)
//		{
//			System.out.println("some mislanius problem");
//		}
//		finally {
//			try {
//				con.close();
//				ps.close();
//				rs.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (Exception e)
//			{
//				System.out.println("Exception during closing");
//			}
//
//		}
//	}
//}