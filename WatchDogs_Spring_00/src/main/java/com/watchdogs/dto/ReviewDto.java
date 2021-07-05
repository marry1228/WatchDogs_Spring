package com.watchdogs.dto;


public class ReviewDto { // 자바에서 Bean 역할. MVC 에서는 Dto : 불러오기 등 DB 값 가져올때 사용 (임시저장소)
	
	//-------------------------------------------Field
	
	//변수이름과 DB 이름은 소문자로 _ 사용 말고!

	int reid;
	int rehit; //조회수 추가 (2021.05.18)
	String userid;
	String retitle;
	String recontent;
	String redate;
	String redeldate;
	
	// 파일 이름 추가
	String refilepath;
	
	
	//-------------------------------------------Constructor

	public ReviewDto() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 2021.05.17 권효은
	 * userid 받아오기   -----> 아이디 불러올때 쓰려나?
	 */
	//id만 받아오는 것 (먼저 만들어 놓은것)
	public ReviewDto(String userid) {
		super();
		this.userid = userid;
	}

	
	

	/*
	 * 2021.05.18 권효은
	 * 상세 페이지 불러오기 수정 더 불러옴 (위의 요소 변경) : docid, dochit 
	 * 21.05.22 파일불러오기 추가 (filepath)
	 */


	public ReviewDto(int reid, String userid, int rehit, String retitle, String redate, String recontent, String refilepath) {
		super();
		this.reid = reid;
		this.rehit = rehit;
		this.userid = userid;
		this.retitle = retitle;
		this.recontent = recontent;
		this.redate = redate;
		this.refilepath = refilepath;
	}
	

	
	
	/*/
	 * 2021.05.19 권효은
	 * 리스트 페이징 처리
	 */
	
	public ReviewDto(int reid,  String retitle, String recontent, String redate, int rehit) {
		super();
		this.reid = reid;
		this.retitle = retitle;
		this.recontent = recontent;
		this.redate = redate;
		this.rehit = rehit;
	}
	
	
	/*
	 * 리스트 불러오기 
	 * 
	 */
	
	public ReviewDto(int reid, int rehit, String userid, String retitle, String recontent, String redate, String redeldate) {
		super();
		this.reid = reid;
		this.rehit = rehit;
		this.userid = userid;
		this.retitle = retitle;
		this.recontent = recontent;
		this.redate = redate;
		this.redeldate = redeldate;
	}


	
	
	//-------------------------------------------Getter & Setter
	// Generate constructor using fields 사용; 오버로드
	public int getReid() {
		return reid;
	}



	public void setReid(int reid) {
		this.reid = reid;
	}

	public int getRehit() {
		return rehit;
	}

	public void setRehit(int rehit) {
		this.rehit = rehit;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRetitle() {
		return retitle;
	}

	public void setRetitle(String retitle) {
		this.retitle = retitle;
	}

	public String getRecontent() {
		return recontent;
	}

	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}

	public String getRedate() {
		return redate;
	}

	public void setRedate(String redate) {
		this.redate = redate;
	}

	public String getRedeldate() {
		return redeldate;
	}

	public void setRedeldate(String redeldate) {
		this.redeldate = redeldate;
	}

	public String getRefilepath() {
		return refilepath;
	}

	public void setRefilepath(String refilepath) {
		this.refilepath = refilepath;
	}
	

	
	

	
	
}//end