package com.bmpl.testengin.utils;

public interface SQLConstants {
	
	static String LOGIN_QUARY = "select user_mst.userid,user_mst.password,right_mst.rightname,right_mst.screen,role_mst.name from user_mst,"
			+ "role_mst,right_mst,role_right_mapping,user_role_mapping where user_mst.uid=user_role_mapping.uid and role_mst.roleid"
			+ "=user_role_mapping.roleid and role_mst.roleid=role_right_mapping.roleid and right_mst.rightid=role_right_mapping.rightid"
			+ " and userid=? and password=?;";

}
