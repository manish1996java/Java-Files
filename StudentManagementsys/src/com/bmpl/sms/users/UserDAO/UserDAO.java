package com.bmpl.sms.users.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bmpl.sms.users.UserDTO.UserDTO;
import com.bmpl.sms.utils.CommonDAO;

public class UserDAO {
	
//	public static void main(String args[]) throws ClassNotFoundException, SQLException
//	{
	public UserDTO doLogin(String userid, String password) throws ClassNotFoundException, SQLException {

		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserDTO userdto = null;
		
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("select userid,password,checkfirstlogin from user_mst where userid = ? and password = ?;");
			ps.setString(1, userid);
			ps.setString(2, password);
			rs=ps.executeQuery();
		
			if(rs.next())
			{
				userdto = new UserDTO();
				userdto.setUserid(rs.getString("userid"));
				userdto.setPassword(rs.getString("password"));
				userdto.setChecklogin(rs.getBoolean("checkfirstlogin"));
				System.out.println("userid ="+rs.getString("userid")+"\tpassword"+rs.getString("password")+"\tcheckfirstlogin"+rs.getBoolean("checkfirstlogin"));
			
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
	return userdto;
	}
}
