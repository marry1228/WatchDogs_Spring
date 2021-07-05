package com.watchdogs.dto;


public class NoticeDto {

	/*/
	 * 2021.05.20 권효은
	 * 공지사항 임시저장소 
	 */
	//-------------------------------------------Field
	int noid;
	int nohit;
	String userid;
	String adid;
	String notitle;
	String nocontent;
	String nodate;
	String nodeldate;
	
	//-------------------------------------------Constructor
	public NoticeDto() {
		// TODO Auto-generated constructor stub
	}

	/*/
	 * 2021.05.25 권효은
	 * 리스트 불러오기 수정
	 */
	public NoticeDto(int noid, String adid, String notitle, String nocontent, String nodate ,int nohit, String nodeldate) {
		super();
		this.noid = noid;
		this.adid = adid;
		this.notitle = notitle;
		this.nocontent = nocontent;
		this.nodate = nodate;
		this.nohit = nohit;
		this.nodeldate = nodeldate;
	}
	
	/*/
	 * 2021.05.20 권효은
	 * 공지 상세정보에 불러올 내용
	 */
	public NoticeDto(int noid, String adid, String notitle, String nocontent, String nodate ,int nohit) {
		super();
		this.noid = noid;
		this.adid = adid;
		this.notitle = notitle;
		this.nocontent = nocontent;
		this.nodate = nodate;
		this.nohit = nohit;
	}
		
		//-------------------------------------------Getter & Setter
		//모든 getter /setter	
		
	
	public int getNoid() {
		return noid;
	}
	public void setNoid(int noid) {
		this.noid = noid;
	}
	public int getNohit() {
		return nohit;
	}
	public void setNohit(int nohit) {
		this.nohit = nohit;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAdid() {
		return adid;
	}
	public void setAdid(String adid) {
		this.adid = adid;
	}
	public String getNotitle() {
		return notitle;
	}
	public void setNotitle(String notitle) {
		this.notitle = notitle;
	}
	public String getNocontent() {
		return nocontent;
	}
	public void setNocontent(String nocontent) {
		this.nocontent = nocontent;
	}
	public String getNodate() {
		return nodate;
	}
	public void setNodate(String nodate) {
		this.nodate = nodate;
	}

	public String getNodeldate() {
		return nodeldate;
	}

	public void setNodeldate(String nodeldate) {
		this.nodeldate = nodeldate;
	}
		
		
		



	
	

}//end
