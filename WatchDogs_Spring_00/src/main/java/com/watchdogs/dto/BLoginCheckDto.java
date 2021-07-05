package com.watchdogs.dto;

import java.sql.Timestamp;

public class BLoginCheckDto { // 자바에서 Bin 역할. MVC 에서는 Dto
	String bId;
	String bTel;
	String bEmail;
	String bName;
	Timestamp bDate;

	
	public BLoginCheckDto() {
		// TODO Auto-generated constructor stub
	}

	public BLoginCheckDto(String bId, String bTel, String bEmail, String bName, Timestamp bDate) {
		super();
		this.bId = bId;
		this.bTel = bTel;
		this.bEmail = bEmail;
		this.bName = bName;
		this.bDate = bDate;
	}

	public String getbTel() {
		return bTel;
	}



	public void setbTel(String bTel) {
		this.bTel = bTel;	
	}



	public String getbEmail() {
		return bEmail;
	}



	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}



	public String getBname() {
		return bName;
	}



	public void setBname(String bName) {
		this.bName = bName;
	}



	public Timestamp getbDate() {
		return bDate;
	}



	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}



	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}
}
