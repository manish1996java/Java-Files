package com.bmpl.sms.users.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.sms.users.DTO.StudentDTO;
import com.bmpl.sms.utils.CommonDAO;

public class DateDAO {
	public ArrayList<StudentDTO> filterByDate(String fromDate,String toDate) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 
		ArrayList<StudentDTO> list = new ArrayList<>();
		StudentDTO sdto = null;
		try {
			con = CommonDAO.getConnection();
			ps = con.prepareStatement("select * from Student_details where date between cast(? as date) and cast(? as date);" );
			ps.setString(1, fromDate);
			ps.setString(2, toDate);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				sdto = new StudentDTO();
			
				sdto.setName(rs.getString("name"));
				sdto.setFatherName(rs.getString("father_name"));
				sdto.setCourse(rs.getString("intrestedcourse"));
				sdto.setPhoneno(rs.getString("phoneno"));
				sdto.setEmail(rs.getString("emailid"));
				sdto.setDob(rs.getDate("dob"));
				sdto.setDate(rs.getDate("date"));
				sdto.setPrefBatchTime(rs.getString("preferbatchtime"));
				sdto.setCollageName(rs.getString("counselor_name"));
				sdto.setCounselorName(rs.getString("counselor_name"));
				sdto.setStatus(rs.getString("status"));
				
				list.add(sdto);
				System.out.println(sdto);
				
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
		return list;
	}
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		DateDAO dd = new DateDAO();
//		dd.filterByDate("2018/08/08", "2018/11/25");
//		
//	}
}
	
	