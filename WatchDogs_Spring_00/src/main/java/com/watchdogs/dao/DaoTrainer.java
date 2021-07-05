package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.DtoTrainer;

public class DaoTrainer {

	DataSource dataSource;
	
	public DaoTrainer() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DtoTrainer> list() { // jy수정5/24
		ArrayList<DtoTrainer> dtos = new ArrayList<DtoTrainer>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select trid, trpw, tremail, trtel, trname, trdate, trdeldate, trcareer, trfilepath, adid from trainer"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String trid = resultSet.getString("trid"); // 속성 명에 유의! 
				String trpw = resultSet.getString("trpw"); // 속성 명에 유의! 
				String tremail = resultSet.getString("tremail"); // 속성 명에 유의! 
				String trtel = resultSet.getString("trtel"); // 속성 명에 유의! 
				String trname = resultSet.getString("trname"); // 속성 명에 유의! 
				String trdate = resultSet.getString("trdate"); // 속성 명에 유의! 
				String trdeldate = resultSet.getString("trdeldate"); // 속성 명에 유의! 
				String trcareer = resultSet.getString("trcareer"); // 속성 명에 유의! 
				String trfilepath = resultSet.getString("trfilepath"); // 속성 명에 유의! 
				String adid = resultSet.getString("adid"); // 속성 명에 유의! 

				System.out.println(" Id = " + trid); // 테스트 용
				
				DtoTrainer dto = new DtoTrainer(trid, trpw, tremail, trtel, trname, trdate, trdeldate, trcareer, trfilepath, adid);
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
	
	public ArrayList<DtoTrainer> currentlist() { // jy수정5/24
		ArrayList<DtoTrainer> dtos = new ArrayList<DtoTrainer>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select trid, trpw, tremail, trtel, trname, trdate, trdeldate, trcareer, trfilepath, adid from trainer where trdeldate is null"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String trid = resultSet.getString("trid"); // 속성 명에 유의! 
				String trpw = resultSet.getString("trpw"); // 속성 명에 유의! 
				String tremail = resultSet.getString("tremail"); // 속성 명에 유의! 
				String trtel = resultSet.getString("trtel"); // 속성 명에 유의! 
				String trname = resultSet.getString("trname"); // 속성 명에 유의! 
				String trdate = resultSet.getString("trdate"); // 속성 명에 유의! 
				String trdeldate = resultSet.getString("trdeldate"); // 속성 명에 유의! 
				String trcareer = resultSet.getString("trcareer"); // 속성 명에 유의! 
				String trfilepath = resultSet.getString("trfilepath"); // 속성 명에 유의! 
				String adid = resultSet.getString("adid"); // 속성 명에 유의! 
				
				System.out.println(" Id = " + trid); // 테스트 용
				
				DtoTrainer dto = new DtoTrainer(trid, trpw, tremail, trtel, trname, trdate, trdeldate, trcareer, trfilepath, adid);
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
	
	public DtoTrainer detail(String trId) { // jy수정5/24
		DtoTrainer dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select trid, trpw, tremail, trtel, trname, trdate, trdeldate, trcareer, trfilepath, adid from trainer where trid = ?"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, trId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String trid = resultSet.getString("trid"); // 속성 명에 유의! 
				String trpw = resultSet.getString("trpw"); // 속성 명에 유의! 
				String tremail = resultSet.getString("tremail"); // 속성 명에 유의! 
				String trtel = resultSet.getString("trtel"); // 속성 명에 유의! 
				String trname = resultSet.getString("trname"); // 속성 명에 유의! 
				String trdate = resultSet.getString("trdate"); // 속성 명에 유의! 
				String trdeldate = resultSet.getString("trdeldate"); // 속성 명에 유의! 
				String trcareer = resultSet.getString("trcareer"); // 속성 명에 유의! 
				String trfilepath = resultSet.getString("trfilepath"); // 속성 명에 유의! 
				String adid = resultSet.getString("adid"); // 속성 명에 유의! 
				
				System.out.println(" Id = " + trid); // 테스트 용
				
				dto = new DtoTrainer(trid, trpw, tremail, trtel, trname, trdate, trdeldate, trcareer, trfilepath, adid);
				
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
	
	public void update(String trId, String trPw, String trEmail, String trTel, String trName, String trCareer, String trDate, String trDelDate, String adminID, String trFilePath) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update trainer set trpw = ?, tremail = ?, trtel = ?, trname = ?, trcareer = ?, trfilepath = ?, adid = ? where trid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, trPw);
			preparedStatement.setString(2, trEmail);
			preparedStatement.setString(3, trTel);
			preparedStatement.setString(4, trName);
			preparedStatement.setString(5, trCareer);
			preparedStatement.setString(6, trFilePath);
			preparedStatement.setString(7, adminID);
			preparedStatement.setString(8, trId);
			
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
	
	public void delete(String trId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update trainer set trdeldate = now() where trid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, trId);
			
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
	
	public void deletecancel(String trId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update trainer set trdeldate = null where trid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, trId);
			
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
	
	public void insert(String trId, String trPw, String trEmail, String trTel, String trName, String trCareer, String trFilePath, String adminID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into trainer (trid, trpw, tremail, trtel, trname, trdate, trcareer, trfilepath, adid) values (?,?,?,?,?,now(),?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, trId);
			preparedStatement.setString(2, trPw);
			preparedStatement.setString(3, trEmail);
			preparedStatement.setString(4, trTel);
			preparedStatement.setString(5, trName);
			preparedStatement.setString(6, trCareer);
			preparedStatement.setString(7, trFilePath);
			preparedStatement.setString(8, adminID);
			
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
