package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.DtoNotice;
import com.watchdogs.dto.DtoDog;

public class DaoNotice {
	
	DataSource dataSource;
	
	public DaoNotice() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DtoNotice> list() {
		ArrayList<DtoNotice> dtos = new ArrayList<DtoNotice>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select noid, notitle, nocontent, nodate, nodeldate, nohit, adid from notice"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int noid = resultSet.getInt("noid"); // 속성 명에 유의! 
				String notitle = resultSet.getString("notitle"); // 속성 명에 유의! 
				String nocontent = resultSet.getString("nocontent"); // 속성 명에 유의! 
				String nodate = resultSet.getString("nodate"); // 속성 명에 유의! 
				String nodeldate = resultSet.getString("nodeldate"); // 속성 명에 유의! 
				int nohit = resultSet.getInt("nohit"); // 속성 명에 유의! 
				String adid = resultSet.getString("adid"); // 속성 명에 유의! 

				System.out.println(" Id = " + noid); // 테스트 용
				
				DtoNotice dto = new DtoNotice(noid, notitle, nocontent, nodate, nodeldate, nohit, adid);
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
	
	public DtoNotice detail(int noId) {
		DtoNotice dto = null;
		 
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select noid, notitle, nocontent, nodate, nodeldate, nohit, adid from notice where noid = ?"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, noId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int noid = resultSet.getInt("noid"); // 속성 명에 유의! 
				String notitle = resultSet.getString("notitle"); // 속성 명에 유의! 
				String nocontent = resultSet.getString("nocontent"); // 속성 명에 유의! 
				String nodate = resultSet.getString("nodate"); // 속성 명에 유의! 
				String nodeldate = resultSet.getString("nodeldate"); // 속성 명에 유의! 
				int nohit = resultSet.getInt("nohit"); // 속성 명에 유의! 
				String adid = resultSet.getString("adid"); // 속성 명에 유의! 
				
				System.out.println(" Id = " + noid); // 테스트 용 
				
				dto = new DtoNotice(noid, notitle, nocontent, nodate, nodeldate, nohit, adid);
				
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
	
	public void update(int noId, String noTitle, String noContent, String noDate, String noDelDate, int noHit, String adminID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update notice set notitle = ?, nocontent = ?, nodate = now() where noid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, noTitle);
			preparedStatement.setString(2, noContent);
			preparedStatement.setInt(3, noId);
			
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
	
	public void delete(int noId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update notice set nodeldate = now() where noid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, noId);
			
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
	
	public void deletecancel(int noId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update notice set nodeldate = null where noid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, noId);
			
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
	
	public void insert(String noTitle, String noContent, String adminID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into notice (notitle, nocontent, nodate, adid) values (?,?,now(),?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, noTitle);
			preparedStatement.setString(2, noContent);
			preparedStatement.setString(3, adminID);
			
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
