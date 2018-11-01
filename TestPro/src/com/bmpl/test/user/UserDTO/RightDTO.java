package com.bmpl.test.user.UserDTO;

public class RightDTO {
	private String rightname;
	private String Screen;
	
	public RightDTO(String rightname,String Screen) {
		this.rightname = rightname;
		this.Screen = Screen;
		
	}
	
	public String getRightname() {
		return rightname;
	}
	public void setRightname(String rightname) {
		this.rightname = rightname;
	}
	public String getScreen() {
		return Screen;
	}
	public void setScreen(String screen) {
		Screen = screen;
	}
	
	

}
