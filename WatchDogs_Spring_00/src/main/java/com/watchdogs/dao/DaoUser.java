package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.DtoUser;

public class DaoUser {
	
	DataSource dataSource;
	
	public DaoUser() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DtoUser> list() {
		ArrayList<DtoUser> dtos = new ArrayList<DtoUser>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select userid, userpw, usertel, useremail, username, userdate, userdeldate from user"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String userid = resultSet.getString("userid"); // 속성 명에 유의! 
				String userpw = resultSet.getString("userpw"); // 속성 명에 유의! 
				String usertel = resultSet.getString("usertel"); // 속성 명에 유의! 
				String useremail = resultSet.getString("useremail"); // 속성 명에 유의! 
				String username = resultSet.getString("username"); // 속성 명에 유의! 
				String userdate = resultSet.getString("userdate"); // 속성 명에 유의! 
				String userdeldate = resultSet.getString("userdeldate"); // 속성 명에 유의! 

				System.out.println(" Id = " + userid); // 테스트 용
				
				DtoUser dto = new DtoUser(userid, userpw, usertel, useremail, username, userdate, userdeldate);
				dtos.add(dto);
				
				
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
		return dtos;
	
	}
	
	public DtoUser detail(String userId) {
		DtoUser dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select userid, userpw, usertel, useremail, username, userdate, userdeldate  from user where userid = ?"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String userid = resultSet.getString("userid"); // 속성 명에 유의! 
				String userpw = resultSet.getString("userpw"); // 속성 명에 유의! 
				String usertel = resultSet.getString("usertel"); // 속성 명에 유의! 
				String useremail = resultSet.getString("useremail"); // 속성 명에 유의! 
				String username = resultSet.getString("username"); // 속성 명에 유의! 
				String userdate = resultSet.getString("userdate"); // 속성 명에 유의! 
				String userdeldate = resultSet.getString("userdeldate"); // 속성 명에 유의! 
				
				System.out.println(" Id = " + userId); // 테스트 용
				
				dto = new DtoUser(userid, userpw, usertel, useremail, username, userdate, userdeldate);
				
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
		return dto;
		
	}
	
	public void update(String userId, String userPw, String userTel, String userEmail, String userName, String userDate, String userDelDate, String adminID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update user set userid = ?, userpw = ?, usertel = ?, useremail = ?, username = ?, userdate = ?, userdeldate = ? where userid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPw);
			preparedStatement.setString(3, userTel);
			preparedStatement.setString(4, userEmail);
			preparedStatement.setString(5, userName);
			preparedStatement.setString(6, userDate);
			preparedStatement.setString(7, userDelDate);
			preparedStatement.setString(8, userId);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(String userId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update user set userdeldate = now() where userid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, userId);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deletecancel(String userId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update user set userdeldate = null where userid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, userId);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insert(String userId, String userPw, String userTel, String userEmail, String userName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into user (userid, userpw, usertel, useremail, username, userdate) values (?,?,?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPw);
			preparedStatement.setString(3, userTel);
			preparedStatement.setString(4, userEmail);
			preparedStatement.setString(5, userName);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
