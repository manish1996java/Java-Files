package com.bmpl.test.user.UserDTO;

import java.util.ArrayList;

public class UserDTO {

	private String userid;
	private String password;
	private String Rolename;
	private ArrayList<RightDTO> rights;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRolename() {
		return Rolename;
	}
	public void setRolename(String rolename) {
		Rolename = rolename;
	}
	public ArrayList<RightDTO> getRights() {
		return rights;
	}
	public void setRights(ArrayList<RightDTO> rights) {
		this.rights = rights;
	}
	
	
	
}
