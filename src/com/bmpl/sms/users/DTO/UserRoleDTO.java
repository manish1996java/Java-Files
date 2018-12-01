package com.bmpl.sms.users.DTO;

public class UserRoleDTO {
	private int id;
	private String user;
	private String role;
	private char status;
	
	
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "UserRoleDTO [id=" + id + ", user=" + user + ", role=" + role + ", status=" + status + "]";
	}
	
	

}
