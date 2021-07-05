package com.watchdogs.dto;

public class DtoDog {
	int dogId;
	String dogName;
	String dogType;
	String dogMF;
	String dogAge;
	String dogAdoptSt;
	String dogDate;
	String dogAdoptDate;
	String dogFilePath;
	String dogTrainComm;
	String adminID;
	String trainerID;
	
	public DtoDog() {
		// TODO Auto-generated constructor stub
	}

	public DtoDog(int dogId, String dogName, String dogType, String dogMF, String dogAge, String dogAdoptSt,
			String dogDate, String dogAdoptDate, String dogFilePath, String dogTrainComm, String adminID,
			String trainerID) {
		super();
		this.dogId = dogId;
		this.dogName = dogName;
		this.dogType = dogType;
		this.dogMF = dogMF;
		this.dogAge = dogAge;
		this.dogAdoptSt = dogAdoptSt;
		this.dogDate = dogDate;
		this.dogAdoptDate = dogAdoptDate;
		this.dogFilePath = dogFilePath;
		this.dogTrainComm = dogTrainComm;
		this.adminID = adminID;
		this.trainerID = trainerID;
	}

	public int getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getDogType() {
		return dogType;
	}

	public void setDogType(String dogType) {
		this.dogType = dogType;
	}

	public String getDogMF() {
		return dogMF;
	}

	public void setDogMF(String dogMF) {
		this.dogMF = dogMF;
	}

	public String getDogAge() {
		return dogAge;
	}

	public void setDogAge(String dogAge) {
		this.dogAge = dogAge;
	}

	public String getDogAdoptSt() {
		return dogAdoptSt;
	}

	public void setDogAdoptSt(String dogAdoptSt) {
		this.dogAdoptSt = dogAdoptSt;
	}

	public String getDogDate() {
		return dogDate;
	}

	public void setDogDate(String dogDate) {
		this.dogDate = dogDate;
	}

	public String getDogAdoptDate() {
		return dogAdoptDate;
	}

	public void setDogAdoptDate(String dogAdoptDate) {
		this.dogAdoptDate = dogAdoptDate;
	}

	public String getDogFilePath() {
		return dogFilePath;
	}

	public void setDogFilePath(String dogFilePath) {
		this.dogFilePath = dogFilePath;
	}

	public String getDogTrainComm() {
		return dogTrainComm;
	}

	public void setDogTrainComm(String dogTrainComm) {
		this.dogTrainComm = dogTrainComm;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(String trainerID) {
		this.trainerID = trainerID;
	}

	

	
	
}
