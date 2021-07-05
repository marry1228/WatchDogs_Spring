package com.watchdogs.dto;

import java.sql.Timestamp;

public class BDtoAdopt {
	
	String dogname;
	String dogtrainst;
	String dogadopttst;
	Timestamp dogdate;
	String dogtraincomm;
	String doggender;
	String trname;
	String dogmf;
	String dogage;
	String dogfilepath;
	int dogid;	
	String dogtype;
	
	
	
	
    
	public BDtoAdopt(String dogname, String dogadopttst, String dogtraincomm, String trname,
			String dogmf, String dogage, String dogfilepath, String dogtype, int dogid, Timestamp dogdate) {
		super();
		this.dogname = dogname;
		this.dogadopttst = dogadopttst;
		this.dogdate = dogdate;
		this.dogtraincomm = dogtraincomm;
		this.trname = trname;
		this.dogmf = dogmf;
		this.dogage = dogage;
		this.dogfilepath = dogfilepath;
		this.dogid = dogid;
		this.dogtype = dogtype;
	}










	public BDtoAdopt(String dogname, String dogadopttst,  String dogtraincomm, String dogmf,
			String dogage, String dogfilepath,Timestamp dogdate, int dogid) {
		super();
		this.dogname = dogname;
		this.dogadopttst = dogadopttst;
		this.dogdate = dogdate;
		this.dogtraincomm = dogtraincomm;
		this.dogmf = dogmf;
		this.dogage = dogage;
		this.dogfilepath = dogfilepath;
		this.dogid = dogid;
	}










	public BDtoAdopt(String dogname, String dogadopttst, String dogtraincomm, String doggender,Timestamp dogdate,String trname) {
		super();
		this.dogname = dogname;
		this.dogadopttst = dogadopttst;
		this.dogdate = dogdate;
		this.dogtraincomm = dogtraincomm;
		this.doggender = doggender;
		this.trname = trname;
	}










	public BDtoAdopt(int dogid, String dogname, String dogadopttst,  String doggender, String dogtraincomm, Timestamp dogdate) {
		super();
		this.dogname = dogname;
		this.dogadopttst = dogadopttst;
		this.dogdate = dogdate;
		this.dogtraincomm = dogtraincomm;
		this.doggender = doggender;
		this.dogid = dogid;
	}





	
	public BDtoAdopt(String dogname, String dogadopttst, String dogtraincomm, String doggender, Timestamp dogdate) {
		super();
		this.dogname = dogname;
		this.dogadopttst = dogadopttst;
		this.dogdate = dogdate;
		this.dogtraincomm = dogtraincomm;
		this.doggender = doggender;
	}






	public BDtoAdopt(String dogname, String doggender,  Timestamp dogdate, String dogadopttst) {
		super();
		this.dogname = dogname;
		this.dogadopttst = dogadopttst;
		this.dogdate = dogdate;
		this.doggender = doggender;
	}
	
	
	
	public String getDogtype() {
		return dogtype;
	}










	public void setDogtype(String dogtype) {
		this.dogtype = dogtype;
	}










	public String getTrname() {
		return trname;
	}
	
	
	
	
	
	
	public BDtoAdopt(String trname) {
		super();
		this.trname = trname;
	}










	public String getDogmf() {
		return dogmf;
	}










	public void setDogmf(String dogmf) {
		this.dogmf = dogmf;
	}










	public String getDogage() {
		return dogage;
	}










	public void setDogage(String dogage) {
		this.dogage = dogage;
	}










	public String getDogfilepath() {
		return dogfilepath;
	}










	public void setDogfilepath(String dogfilepath) {
		this.dogfilepath = dogfilepath;
	}










	public void setTrname(String trname) {
		this.trname = trname;
	}

	
	public BDtoAdopt() {
		// TODO Auto-generated constructor stub
	}

	
	
	public int getDogid() {
		return dogid;
	}

	public void setDogid(int dogid) {
		this.dogid = dogid;
	}

	public String getDogname() {
		return dogname;
	}



	public void setDogname(String dogname) {
		this.dogname = dogname;
	}



	public String getDoggender() {
		return doggender;
	}



	public void setDoggender(String doggender) {
		this.doggender = doggender;
	}



	public String getDogtraincomm() {
		return dogtraincomm;
	}



	public void setDogtraincomm(String dogtraincomm) {
		this.dogtraincomm = dogtraincomm;
	}



	public String getDogtrainst() {
		return dogtrainst;
	}



	public void setDogtrainst(String dogtrainst) {
		this.dogtrainst = dogtrainst;
	}



	public String getDogadopttst() {
		return dogadopttst;
	}



	public void setDogadopttst(String dogadopttst) {
		this.dogadopttst = dogadopttst;
	}







	public Timestamp getDogdate() {
		return dogdate;
	}







	public void setDogdate(Timestamp dogdate) {
		this.dogdate = dogdate;
	}


}
