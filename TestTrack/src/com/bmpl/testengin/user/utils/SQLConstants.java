package com.bmpl.testengin.user.utils;

public interface SQLConstants {
	String LOGIN_QURY="select user_mst.userid,user_mst.password,right_mst.rightname,right_mst.screen,role_mst.name from user_mst,"
			+ "role_mst,right_mst,role_right_mapping,user_role_mapping where user_mst.uid=user_role_mapping.uid and role_mst.roleid"
			+ "=user_role_mapping.roleid and role_mst.roleid=role_right_mapping.roleid and right_mst.rightid=role_right_mapping.rightid"
			+ " and userid=? and password=?;";
	String QUESTION_UPLOAD_SQL="incert into question(id,name,optiona,optionb,optionc,optiond,ans,score) values(?,?,?,?,?,?,?,?);";
}
