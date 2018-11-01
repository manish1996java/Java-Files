package com.bmpl.testengin.user.userDTO;

public class RightDTO {
	private String right;
	private String screen;
	
	public RightDTO(String right,String screen)
	{
		this.right=right;
		this.screen=screen;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}
	
}
