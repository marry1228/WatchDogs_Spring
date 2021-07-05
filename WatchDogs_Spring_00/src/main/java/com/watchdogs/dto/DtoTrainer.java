package com.watchdogs.dto;

import java.sql.Timestamp;

public class DtoTrainer { // 자바에서 Bin 역할. MVC 에서는 Dto
	String trId;
	String trPw; // jy추가5/24
	String trEmail;
	String trTel;
	String trName;
	String trDate;
	String trDelDate;
	String trCareer; // jy추가5/24
	String trFilePath; // jy추가5/24
	String adminID;
	
	public DtoTrainer() {
		// TODO Auto-generated constructor stub
	}

	// Generate constructor using fields 사용했음! ; 오버로드
	// jy수정5/24start
	public DtoTrainer(String trId, String trPw, String trEmail, String trTel, String trName, String trDate,
			String trDelDate, String trCareer, String trFilePath, String adminID) {
		super();
		this.trId = trId;
		this.trPw = trPw;
		this.trEmail = trEmail;
		this.trTel = trTel;
		this.trName = trName;
		this.trDate = trDate;
		this.trDelDate = trDelDate;
		this.trCareer = trCareer;
		this.trFilePath = trFilePath;
		this.adminID = adminID;
	}

	public String getTrId() {
		return trId;
	}

	public void setTrId(String trId) {
		this.trId = trId;
	}

	public String getTrPw() {
		return trPw;
	}

	public void setTrPw(String trPw) {
		this.trPw = trPw;
	}

	public String getTrEmail() {
		return trEmail;
	}

	public void setTrEmail(String trEmail) {
		this.trEmail = trEmail;
	}

	public String getTrTel() {
		return trTel;
	}

	public void setTrTel(String trTel) {
		this.trTel = trTel;
	}

	public String getTrName() {
		return trName;
	}

	public void setTrName(String trName) {
		this.trName = trName;
	}

	public String getTrDate() {
		return trDate;
	}

	public void setTrDate(String trDate) {
		this.trDate = trDate;
	}

	public String getTrDelDate() {
		return trDelDate;
	}

	public void setTrDelDate(String trDelDate) {
		this.trDelDate = trDelDate;
	}

	public String getTrCareer() {
		return trCareer;
	}

	public void setTrCareer(String trCareer) {
		this.trCareer = trCareer;
	}

	public String getTrFilePath() {
		return trFilePath;
	}

	public void setTrFilePath(String trFilePath) {
		this.trFilePath = trFilePath;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	
	
	

	// jy수정5/24end
	
	
	

}
