package com.watchdogs.dao;

import java.util.ArrayList;

import com.watchdogs.dto.ContentDto_new;


public interface IDao_new {
	
	// 전체검색
	public ArrayList<ContentDto_new> listDao();
	// 입력
	public void writeDao(String name, String telno, String address, String email, String relation);
	// 삭제
	public void deleteDao(String seqno);
	// 수정
	public void modifyDao(String name, String telno, String address, String email, String relation, String seqno);
	// 내용검색
	public ContentDto_new viewDao(String seqno);
	// 조건검색
	public ArrayList<ContentDto_new> listQuery(String query, String content);

}
