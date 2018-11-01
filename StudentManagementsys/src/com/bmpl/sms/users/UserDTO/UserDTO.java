package com.bmpl.sms.users.UserDTO;

public class UserDTO {
	private String userid;
	private String password;
	private boolean checklogin;
	
	
	
	public boolean isChecklogin() {
		return checklogin;
	}
	public void setChecklogin(boolean checklogin) {
		this.checklogin = checklogin;
	}
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
	
}
