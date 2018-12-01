package com.bmpl.sms.users.DTO;

import java.util.Date;

public class StudentDTO {
	private String name;
	private String fatherName;
	private String address;
	private String email;
	private String course;
	private String phoneno;
	private Date dob;
	private Date date;
	private String prefBatchTime;
	private String collageName;
	private String counselorName;
	private String status;
	private String daypreference;
	private String occupation;
	private String aboutbmpl;
	
	
	
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDaypreference() {
		return daypreference;
	}
	public void setDaypreference(String daypreference) {
		this.daypreference = daypreference;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAboutbmpl() {
		return aboutbmpl;
	}
	public void setAboutbmpl(String aboutbmpl) {
		this.aboutbmpl = aboutbmpl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPrefBatchTime() {
		return prefBatchTime;
	}
	public void setPrefBatchTime(String prefBatchTime) {
		this.prefBatchTime = prefBatchTime;
	}
	public String getCollageName() {
		return collageName;
	}
	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}
	public String getCounselorName() {
		return counselorName;
	}
	public void setCounselorName(String counselorName) {
		this.counselorName = counselorName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "StudentDTO [name=" + name + ", fatherName=" + fatherName + ", address=" + address + ", email=" + email
				+ ", course=" + course + ", phoneno=" + phoneno + ", dob=" + dob + ", date=" + date + ", prefBatchTime="
				+ prefBatchTime + ", collageName=" + collageName + ", counselorName=" + counselorName + ", status="
				+ status + ", daypreference=" + daypreference + ", occupation=" + occupation + ", aboutbmpl="
				+ aboutbmpl + "]";
	}

}
