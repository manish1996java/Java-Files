package com.bmpl.sms.users.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.sms.users.DTO.RightDTO;
import com.bmpl.sms.users.DTO.UserDTO;
import com.bmpl.sms.users.DTO.UserRoleDTO;
import com.bmpl.sms.utils.CommonDAO;
import com.bmpl.sms.utils.SQLConstants;

public class UserRoleDAO {

	public ArrayList<UserRoleDTO> userRole() throws ClassNotFoundException, SQLException {

		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserRoleDTO urDTO = null;
		ArrayList<UserRoleDTO> userrole = new ArrayList<>(); 
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("select user_mst.status,user_mst.uid,user_mst.userid,role_mst.rolename from user_mst,role_mst,user_role_mapping where user_mst.uid = user_role_mapping.uid and role_mst.roleid = user_role_mapping.roleid");			
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				urDTO = new UserRoleDTO();
				urDTO.setId(rs.getInt("uid"));
				urDTO.setUser(rs.getString("userid"));
				urDTO.setRole(rs.getString("rolename"));
				urDTO.setStatus(rs.getString("status").charAt(0));
				userrole.add(urDTO);
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
	return userrole;
	}
	
	public void doEnableUser(int uid) throws ClassNotFoundException, SQLException {		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserRoleDTO urDTO = null;
		ArrayList<UserRoleDTO> userrole = new ArrayList<>(); 
		
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("update user_mst set status='y' where uid=?");			
			ps.setInt(1, uid);
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

	public void doDisableUser(int uid) throws ClassNotFoundException, SQLException {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	UserRoleDTO urDTO = null;
	ArrayList<UserRoleDTO> userrole = new ArrayList<>(); 
	
	try {
		con = CommonDAO.getConnection();
		ps = con.prepareStatement("update user_mst set status='n' where uid=?");
		ps.setInt(1, uid);
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
