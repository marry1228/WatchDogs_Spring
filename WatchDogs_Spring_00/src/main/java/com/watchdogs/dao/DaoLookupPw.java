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

public class DaoLookupPw {
	
	DataSource dataSource;
	
	public DaoLookupPw() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String lookuppw(String userid, String userpwquiz) {
		String searchedPw = "";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select userpw from user where userid = ? and userpwquiz = ?"; 
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, userid);
			preparedStatement.setString(2, userpwquiz);
			
			resultSet = preparedStatement.executeQuery(); // 쿼리문 실행

			
			while(resultSet.next()) {
				searchedPw = (resultSet.getString("userpw").trim());
			}

			
			preparedStatement.close();
			resultSet.close();
			
			if(searchedPw.equals("")) {
				searchedPw = "";
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
		return searchedPw;
	}
	
}
