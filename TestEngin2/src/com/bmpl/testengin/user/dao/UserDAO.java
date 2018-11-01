package com.bmpl.testengin.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.testengin.user.dto.RightDTO;
import com.bmpl.testengin.user.dto.UserDTO;
import com.bmpl.testengin.utils.CommonDAO;
import com.bmpl.testengin.utils.SQLConstant;

public class UserDAO {
	
//	public static void main(String args[])
//	{
	
	public UserDTO doLogin(String username,String password) throws ClassNotFoundException, SQLException
	{
	Connection con = null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	SQLConstant sqlcons=null;
	UserDTO userDTO=null;
	ArrayList<RightDTO> right=new ArrayList<>();
	
	
	String message="Invalid Userid or password";
	try {
	con=CommonDAO.getConnection();
	
	ps=con.prepareStatement(sqlcons.LOGIN_SQL);
	ps.setString(1, username);
	ps.setString(2, password);
	rs=ps.executeQuery();
	
	
	while(rs.next())
	{
			if(userDTO==null)
			{
				userDTO = new UserDTO();
				userDTO.setUserid(rs.getString("userid"));
				userDTO.setPassword(rs.getString("password"));
				userDTO.setRoleName(rs.getString("name"));
				userDTO.setRights(right);
			}
			RightDTO rightDTO =  new RightDTO(rs.getString("rightname"),rs.getString("screen"));
			right.add(rightDTO);
	}
//	if(rs.next())
//	{
//		message= "Welcome"+username;
//	}
//	if(ps!=null) {
//	System.out.println("Statemnt Prepared");
//	}
//	if(rs!=null)
//	{
//	System.out.println("Query Executed");
//	}
	
	
	return userDTO;
	
	
	}finally
	{
		if(rs!=null)
		{
			rs.close();
		}
		if(ps!=null)
		{
			ps.close();
		}
		if(con!= null) {
			con.close();
		}
		
	}
	}
}