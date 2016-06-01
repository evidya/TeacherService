package com.vidya.teacherServices.model;

import java.sql.Date;

import javax.persistence.Column;

public class TeacherAccount {
	private long teacherID;
	
	private String teacherFirstName;
	
	private String teacherLastName;
	
	private String teacherEmail;
	
	private String teacherPhone;
	
	private String teacherLocation;
	 
	private Integer teacherIsElementary;
	 
	private Integer teacherIsMiddle;
	 
	private Integer teacherIsHigh;
	 
	private String teacherStatus;
	 
	private String teacherPassword;
	
	public long getTeacherID() {
		return teacherID;
	}

	public String getTeacherFirstName() {
		return teacherFirstName;
	}

	public String getTeacherLastName() {
		return teacherLastName;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public String getTeacherLocation() {
		return teacherLocation;
	}

	public Integer getTeacherIsElementary() {
		return teacherIsElementary;
	}

	public Integer getTeacherIsMiddle() {
		return teacherIsMiddle;
	}

	public Integer getTeacherIsHigh() {
		return teacherIsHigh;
	}

	public String getTeacherStatus() {
		return teacherStatus;
	}

	

	public void setTeacherID(long teacherID) {
		this.teacherID = teacherID;
	}

	public void setTeacherFirstName(String teacherFirstName) {
		this.teacherFirstName = teacherFirstName;
	}

	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public void setTeacherLocation(String teacherLocation) {
		this.teacherLocation = teacherLocation;
	}

	public void setTeacherIsElementary(Integer teacherIsElementary) {
		this.teacherIsElementary = teacherIsElementary;
	}

	public void setTeacherIsMiddle(Integer teacherIsMiddle) {
		this.teacherIsMiddle = teacherIsMiddle;
	}

	public void setTeacherIsHigh(Integer teacherIsHigh) {
		this.teacherIsHigh = teacherIsHigh;
	}

	public void setTeacherStatus(String teacherStatus) {
		this.teacherStatus = teacherStatus;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	
	 
	 
}
