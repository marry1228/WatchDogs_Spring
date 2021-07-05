package com.watchdogs.dto;

import java.sql.Timestamp;

public class BListDto { // 자바에서 Bin 역할. MVC 에서는 Dto
	String bId;

	
	public BListDto() {
		// TODO Auto-generated constructor stub
	}

	// Generate constructor using fields 사용했음! ; 오버로드
	public BListDto(String bId) {
		super();
		this.bId = bId;
	}
	
	

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}
}
