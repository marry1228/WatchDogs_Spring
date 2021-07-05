package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.FileDto;


public class FileDao {

	DataSource dataSource;
	//FileDto dto = new FileDto();
	public FileDao(){
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			System.out.println("FileDB연결 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("FileDB연결 실패");
		}
	}
	
	public int upload(String filename, String filerealname) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into document (filename, filerealname) values (?, ?)";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, filename);
			preparedStatement.setString(2, filerealname);
			
			preparedStatement.executeUpdate();
			
			System.out.println("upload 데이터 로드 성공");
		}catch(SQLException e) {
			System.out.println("upload 데이터 로드 실패");
			e.printStackTrace();
			//정상적이든, 에러가 걸리든 무조건 final로 와라 
		}finally{
			try {
				if(preparedStatement !=null) preparedStatement.close();
				if(connection !=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
		}
		return -1;
	}//fileupload2메소드 end
	
	
	
}//end
