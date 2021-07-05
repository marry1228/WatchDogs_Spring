package com.watchdogs.dto;

public class FileDto {
	
	/*/
	 * 2021.05.20 권효은
	 * 파일 업로드 방식2
	 */
	
	//-------------------------------------------Field
	String filename;
	String filerealname;
	
	//-------------------------------------------Constructor
	public FileDto() {
		// TODO Auto-generated constructor stub
	}

	public FileDto(String filename, String filerealname) {
		super();
		this.filename = filename;
		this.filerealname = filerealname;
	}

	//-------------------------------------------Getter & Setter	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilerealname() {
		return filerealname;
	}

	public void setFilerealname(String filerealname) {
		this.filerealname = filerealname;
	}
	
	
	
	
	
	
}
