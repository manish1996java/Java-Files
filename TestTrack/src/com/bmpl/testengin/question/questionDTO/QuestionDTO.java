package com.bmpl.testengin.question.questionDTO;

public class QuestionDTO {
	
	private int serialId;
	private String quesName;
	private String option[] = new String[4];
	private String rightAns;
	private int score;
	
	
	
	public int getSerialId() {
		return serialId;
	}
	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}
	public String getQuesName() {
		return quesName;
	}
	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}
	public String[] getOption() {
		return option;
	}
	public void setOption(String[] option) {
		this.option = option;
	}
	public String getRightAns() {
		return rightAns;
	}
	public void setRightAns(String rightAns) {
		this.rightAns = rightAns;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	
}
