package com.watchdogs.dto;

public class DtoReview {
	int reId;
	String reTitle;
	String reContent;
	String reDate;
	String reDelDate;
	int reHit;
	String reFilePath;
	String userID;
	
	public DtoReview() {
		// TODO Auto-generated constructor stub
	}

	public DtoReview(int reId, String reTitle, String reContent, String reDate, String reDelDate, int reHit,
			String reFilePath, String userID) {
		super();
		this.reId = reId;
		this.reTitle = reTitle;
		this.reContent = reContent;
		this.reDate = reDate;
		this.reDelDate = reDelDate;
		this.reHit = reHit;
		this.reFilePath = reFilePath;
		this.userID = userID;
	}

	public int getReId() {
		return reId;
	}

	public void setReId(int reId) {
		this.reId = reId;
	}

	public String getReTitle() {
		return reTitle;
	}

	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public String getReDate() {
		return reDate;
	}

	public void setReDate(String reDate) {
		this.reDate = reDate;
	}

	public String getReDelDate() {
		return reDelDate;
	}

	public void setReDelDate(String reDelDate) {
		this.reDelDate = reDelDate;
	}

	public int getReHit() {
		return reHit;
	}

	public void setReHit(int reHit) {
		this.reHit = reHit;
	}

	public String getReFilePath() {
		return reFilePath;
	}

	public void setReFilePath(String reFilePath) {
		this.reFilePath = reFilePath;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	
	
	
	
	
}
