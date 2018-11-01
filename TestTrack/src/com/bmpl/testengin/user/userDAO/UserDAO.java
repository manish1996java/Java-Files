package com.bmpl.testengin.user.userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.testengin.user.userDTO.RightDTO;
import com.bmpl.testengin.user.userDTO.UserDTO;
import com.bmpl.testengin.user.utils.CommonDAO;
import com.bmpl.testengin.user.utils.SQLConstants;

public class UserDAO {
	
	public UserDTO doLogin(String username,String password) throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDTO userDTO = null;
		ArrayList<RightDTO> right =  new ArrayList<>();
		try {
		con = CommonDAO.getConnection();
		ps =  con.prepareStatement(SQLConstants.LOGIN_QURY);
		ps.setString(1, username);
		ps.setString(2, password);
//		System.out.println("Statement Prepared");
		rs= ps.executeQuery();
		
//		System.out.println("Execute Query");
		
		while(rs.next())
		{
			if(userDTO==null)
			{
				userDTO =  new UserDTO();
				userDTO.setPassword(rs.getString("password"));
				userDTO.setRole(rs.getString("name"));
				userDTO.setUserid(rs.getString("userid"));
				userDTO.setRight(right);
			}
			right.add(new RightDTO(rs.getString("rightname"),rs.getString("screen")));
		}
		
		return userDTO;
	}finally {
		if(rs != null)
		{
			rs.close();
		}
		if(ps != null)
		{
		ps.close();
		}
		if(con != null){
		con.close();	
		}
		
	}
}
	
	public UserDTO doRegistraion(String userName, String userId, String password, String confPassword, String role) throws SQLException, ClassNotFoundException
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDTO userDTO = null;
		
		con = CommonDAO.getConnection();
		ps = con.prepareStatement("insert into user_mst (userid,password) values (?,?);");
		ps.setString(1,userId );
		ps.setString(2,password);
		ps.executeUpdate();
		
		System.out.println("uid is :" +rs.getInt("uid"));
		
		if(userDTO == null)
		{
			userDTO = new UserDTO();
			userDTO.setUserid(userId);
			userDTO.setPassword(password);
		}
		
		return userDTO;
	}
}
		

