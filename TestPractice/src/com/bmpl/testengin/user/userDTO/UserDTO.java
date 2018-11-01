package com.bmpl.testengin.user.userDTO;

import java.util.ArrayList;

public class UserDTO {
	private String userid;
	private String password;
	private String role;
	private ArrayList<RightDTO> right;
	
	
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<RightDTO> getRight() {
		return right;
	}
	public void setRight(ArrayList<RightDTO> right) {
		this.right = right;
	}
	
	

}
