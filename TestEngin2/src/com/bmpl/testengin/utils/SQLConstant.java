package com.bmpl.testengin.utils;

public interface SQLConstant {
	
//	String LOGIN_SQL="Select userid,password from user_mst where userid=? and password=?";
	String LOGIN_SQL="select user_mst.userid,user_mst.password,role_mst.name,right_mst.rightname"
			+ ",right_mst.screen from user_mst,role_mst,user_role_mapping,right_mst,role_right_mapping"
			+ " where user_mst.uid=user_role_mapping.uid and role_mst.roleid=user_role_mapping.roleid "
			+ "and role_mst.roleid=role_right_mapping.roleid and right_mst.rightid=role_right_mapping.rightid"
			+ " and user_mst.userid=? and user_mst.password=?;";
	
}
