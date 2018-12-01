package com.bmpl.sms.users.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.sms.users.DTO.RightDTO;
import com.bmpl.sms.users.DTO.UserDTO;
import com.bmpl.sms.utils.CommonDAO;
import com.bmpl.sms.utils.SQLConstants;

public class UserDAO {
	

	
	//to check whether the entered login details are correct or not.
	public UserDTO doLogin(String userid, String password) throws ClassNotFoundException, SQLException {

		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserDTO userdto = null;
		ArrayList<RightDTO> right = new ArrayList<>(); 
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement(SQLConstants.LOGIN_QUARY);
			ps.setString(1, userid);
			ps.setString(2, password);
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				if(userdto == null)
				{
					
					userdto = new UserDTO();
					userdto.setUserid(rs.getString("userid"));
					userdto.setPassword(rs.getString("password"));
					userdto.setRolename(rs.getString("rolename"));
					userdto.setChecklogin(rs.getBoolean("checkfirstlogin"));
					userdto.setRights(right);
				}
				
				RightDTO rightDTO = new RightDTO(rs.getString("rightname"),rs.getString("screen"));
				right.add(rightDTO);
			
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

public void CreateNewUser(String userid, String password) throws ClassNotFoundException, SQLException {

		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("WITH getval(uid) as (INSERT INTO user_mst(userid,password) VALUES(?,?) RETURNING uid)INSERT into user_role_mapping(uid) SELECT uid from getval;");
			ps.setString(1, userid);
			ps.setString(2, password);
			ps.executeUpdate();
			
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
}
