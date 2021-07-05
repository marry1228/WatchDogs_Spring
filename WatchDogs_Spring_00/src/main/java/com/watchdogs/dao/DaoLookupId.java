package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.DtoTrainer;
import com.watchdogs.dto.DtoUser;


public class DaoLookupId {
	
	DataSource dataSource;
	
	public DaoLookupId() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String lookupId(String useremail, String username) {
		String searchedId = "";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select userid from user where useremail = ? and username = ?"; 
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, useremail);
			preparedStatement.setString(2, username);
			
			resultSet = preparedStatement.executeQuery(); // 쿼리문 실행
			
			while(resultSet.next()) {
				searchedId = (resultSet.getString("userid").trim());
			}
			
			preparedStatement.close();
			resultSet.close();
			
			if(searchedId.equals("")) {
				searchedId = "";
			}else { 
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally { // 메모리에서 정리 
			try {
				if(resultSet != null) resultSet.close(); // resultset이 비어있지 않으면, 정리한다. 
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		return searchedId;
	}
	
}
