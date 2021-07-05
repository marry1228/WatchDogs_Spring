package com.watchdogs.dto;

public class DtoNotice {
	int noId;
	String noTitle;
	String noContent;
	String noDate;
	String noDelDate;
	int noHit;
	String adminID;
	
	public DtoNotice() {
		// TODO Auto-generated constructor stub
	}

	public DtoNotice(int noId, String noTitle, String noContent, String noDate, String noDelDate, int noHit,
			String adminID) {
		super();
		this.noId = noId;
		this.noTitle = noTitle;
		this.noContent = noContent;
		this.noDate = noDate;
		this.noDelDate = noDelDate;
		this.noHit = noHit;
		this.adminID = adminID;
	}

	public int getNoId() {
		return noId;
	}

	public void setNoId(int noId) {
		this.noId = noId;
	}

	public String getNoTitle() {
		return noTitle;
	}

	public void setNoTitle(String noTitle) {
		this.noTitle = noTitle;
	}

	public String getNoContent() {
		return noContent;
	}

	public void setNoContent(String noContent) {
		this.noContent = noContent;
	}

	public String getNoDate() {
		return noDate;
	}

	public void setNoDate(String noDate) {
		this.noDate = noDate;
	}

	public String getNoDelDate() {
		return noDelDate;
	}

	public void setNoDelDate(String noDelDate) {
		this.noDelDate = noDelDate;
	}

	public int getNoHit() {
		return noHit;
	}

	public void setNoHit(int noHit) {
		this.noHit = noHit;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	

	
	
	
}
