package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.DtoNotice;
import com.watchdogs.dto.DtoReview;

public class DaoReview {
	
	DataSource dataSource;
	
	public DaoReview() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DtoReview> list() {
		ArrayList<DtoReview> dtos = new ArrayList<DtoReview>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select reid, retitle, recontent, redate, redeldate, rehit, refilepath, userid from review"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int reid = resultSet.getInt("reid"); // 속성 명에 유의! 
				String retitle = resultSet.getString("retitle"); // 속성 명에 유의! 
				String recontent = resultSet.getString("recontent"); // 속성 명에 유의! 
				String redate = resultSet.getString("redate"); // 속성 명에 유의! 
				String redeldate = resultSet.getString("redeldate"); // 속성 명에 유의! 
				int rehit = resultSet.getInt("rehit"); // 속성 명에 유의! 
				String refilepath = resultSet.getString("refilepath"); // 속성 명에 유의! 
				String userid = resultSet.getString("userid"); // 속성 명에 유의! 

				System.out.println(" Id = " + reid); // 테스트 용
				
				DtoReview dto = new DtoReview(reid, retitle, recontent, redate, redeldate, rehit, refilepath, userid);
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
	
	public DtoReview detail(int reId) {
		DtoReview dto = null;
		 
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select reid, retitle, recontent, redate, redeldate, rehit, refilepath, userid from review where reid = ?"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, reId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int reid = resultSet.getInt("reid"); // 속성 명에 유의! 
				String retitle = resultSet.getString("retitle"); // 속성 명에 유의! 
				String recontent = resultSet.getString("recontent"); // 속성 명에 유의! 
				String redate = resultSet.getString("redate"); // 속성 명에 유의! 
				String redeldate = resultSet.getString("redeldate"); // 속성 명에 유의! 
				int rehit = resultSet.getInt("rehit"); // 속성 명에 유의! 
				String refilepath = resultSet.getString("refilepath"); // 속성 명에 유의! 
				String userid = resultSet.getString("userid"); // 속성 명에 유의! 
				
				System.out.println(" Id = " + reid); // 테스트 용
				
				dto = new DtoReview(reid, retitle, recontent, redate, redeldate, rehit, refilepath, userid);
				
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
	
	public void update(int docId, String docTitle, String docContent, String docType, String docDate, String docDelDate, String userID, String adminID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update document set doctitle = ?, doccontent = ?, doctype = ?, docdate = ?, docdeldate = ?, user_userid = ?, admin_adid = ? where docid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, docTitle);
			preparedStatement.setString(2, docContent);
			preparedStatement.setString(3, docType);
			preparedStatement.setString(4, docDate);
			preparedStatement.setString(5, docDelDate);
			preparedStatement.setString(6, userID);
			preparedStatement.setString(7, adminID);
			preparedStatement.setInt(8, docId);
			
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
	
	public void delete(int reId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update review set redeldate = now() where reid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, reId);
			
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
	
	public void deletecancel(int reId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update review set redeldate = null where reid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, reId);
			
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
	
	public void insert(String docTitle, String docContent, String docType, String userID, String adminID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into document (doctitle, doccontent, doctype, docdate, user_userid, admin_adid) values (?,?,?,now(),?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, docTitle);
			preparedStatement.setString(2, docContent);
			preparedStatement.setString(3, docType);
			preparedStatement.setString(4, userID);
			preparedStatement.setString(5, adminID);
			
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
