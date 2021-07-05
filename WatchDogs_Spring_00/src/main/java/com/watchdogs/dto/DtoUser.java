package com.watchdogs.dto;

public class DtoUser {
	String userId;
	String userPw;
	String userTel;
	String userEmail;
	String userName;
	String userDate;
	String userDelDate;
	

	public DtoUser() {
		// TODO Auto-generated constructor stub
	}

	public DtoUser(String userId, String userPw, String userTel, String userEmail, String userName, String userDate,
			String userDelDate) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userDate = userDate;
		this.userDelDate = userDelDate;
	
	}
	
	public DtoUser(String userId, String userEmail, String userName,
			String userDelDate) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userDelDate = userDelDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDate() {
		return userDate;
	}

	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}

	public String getUserDelDate() {
		return userDelDate;
	}

	public void setUserDelDate(String userDelDate) {
		this.userDelDate = userDelDate;
	}


	
	
	
}
