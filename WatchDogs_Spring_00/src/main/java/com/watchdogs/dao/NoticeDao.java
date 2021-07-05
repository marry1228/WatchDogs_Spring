package com.watchdogs.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.NoticeDto;


public class NoticeDao {
	
	DataSource dataSource;
	public NoticeDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			System.out.println("Notice DB연결 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Notice DB연결 실패");
		}
	}
	//-------------------------------------------------------------HE part 
	/*
	 *  2021.05. 20 권효은
	 *  공지 목록 불러오기
	 */
	public ArrayList<NoticeDto> noticeList(int clickPage, int numInAPage, String searchCategory, String searchWord) {
		//여러개의 list 이므로 arraylist
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();
		
		String query = "null";
		String query2 = "null";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		
		try {
			if(searchCategory.equals("all"))
			{	
				query = "select noid, adid, notitle, nocontent, nodate, nohit, nodeldate from notice ";
				query2 = "where notitle like '%"+searchWord+"%' or nocontent like '%"+searchWord+"%' and nodeldate is null order by noid desc limit ?, ? ";
				
			}else if(searchCategory.equals("title")) {
				
				query = "select noid, adid, notitle, nocontent, nodate, nohit, nodeldate from notice ";
				query2 ="where notitle like '%"+searchWord+"%' and nodeldate is null order by noid desc limit ?, ? ";
				
			}else if(searchCategory.equals("content")) {
				
				query = "select noid, adid, notitle, nocontent, nodate, nohit, nodeldate from notice ";
				query2= "where nocontent like '%"+searchWord+"%' and nodeldate is null order by noid desc limit ?, ? ";

			}
				
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query +	query2);
			System.out.println(query);
			int defpage = clickPage -1;
			preparedStatement.setInt(1, defpage * numInAPage); //여기에 그냥 요청 페이지를 넣으면 ? 안됨
			//10(numInApage)개 기준이면 0에서 -> 0, 1 이 들어오면 10, 2가 들어오면 20 이렇게 되어야함 
			//즉 처음 물음표는 값이 계속 limit해 놓은 페이지 다음게 시작해야하므로  clickpage * numInApage 인데, 첫시작은 0인게 좋음
			preparedStatement.setInt(2, numInAPage);
			
			resultSet = preparedStatement.executeQuery();//쿼리문 실행한 결과값
			
			
			while(resultSet.next()) {
				int noid = resultSet.getInt(1);
				String adid = resultSet.getString(2);
				String notitle = resultSet.getString(3);
				String nocontent = resultSet.getString(4);
				String nodate = resultSet.getString(5); 
				int nohit = resultSet.getInt(6);
				String nodeldate = resultSet.getString(7);
				
				NoticeDto dto = new NoticeDto(noid, adid, notitle, nocontent, nodate, nohit, nodeldate);
				list.add(dto); 
				System.out.println("NoticeList 데이터 로드 성공");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("NoticeList 데이터 로드 실패");
		}finally { // 메모리에서 정리 
			try {
				if(resultSet != null) resultSet.close(); // resultset이 비어있지 않으면, 정리한다. 
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				System.out.println("NoticeList 데이터 final 성공");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}//noticeList end
	
	/*
	 *  2021.05.18 권효은
	 *  공지 상세 페이지
	 */
	public NoticeDto noticeDetail(String noid) {
		
		NoticeDto dto =null; 
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select noid, adid, notitle, nocontent, nodate, nohit from notice where noid = ? and nodeldate is null";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, Integer.parseInt(noid));  // ?인 것을 뭐로 하겠다! 
			//preparedStatement.setString(2, adid);  
		
			resultSet = preparedStatement.executeQuery(); // 그 문장을 가지고 쿼리문을 실행한 값을 받아둠
			
			while(resultSet.next()) {
				
				int noId = resultSet.getInt(1); 
				String adid = resultSet.getString(2);
				String notitle = resultSet.getString(3);
				String nocontent = resultSet.getString(4);
				String nodate = resultSet.getString(5);
				int nohit = resultSet.getInt(6); 
				

				dto = new NoticeDto(noId, adid,notitle, nocontent, nodate, nohit);
				System.out.println("noticeDetail 데이터 로드 성공");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("noticeDetail 데이터 로드 실패");
		}finally { 
			try {
				if(resultSet != null) resultSet.close(); 
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	
	}//noticeDetail end
	
	/*/
	 * 2021.05.20 권효은
	 * 페이지 총 목록 행의 갯수 구하기 (게시물 수)
	 */
	public int countTotalRows() {
		int count = 0;
	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select count(*) from notice";  //게시물에 있는 모든 게시물 갯수 가져오기

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				count = resultSet.getInt(1);
				System.out.println("리스트 카운트 성공");
			}
		}catch (Exception e) {
			System.out.println("리스트 카운트 실패");
			e.printStackTrace();
		}finally { // 메모리에서 정리 
			try {
				if(resultSet != null) resultSet.close(); // resultset이 비어있지 않으면, 정리한다. 
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//finally

			return count;

	}//countlist end
		
	/*
	 * 2021.05. 20 권효은
	 * 	조회수
	 */
	
	public int countHit(int noid) {
		//int 로 변경

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	//조회수 저장공간
	int countRead = 0;
	System.out.println("쿼리 전 조회수 :" + countRead);
	try {
		connection = dataSource.getConnection();
		String query = "update notice set nohit = nohit + 1 where noid = ? " ;
		preparedStatement = connection.prepareStatement(query);
		
		//query문 안에 뭐넣을지 정해줌
		preparedStatement.setInt(1, noid);  // ?인 것을 뭐로 하겠다! 
		
		System.out.println("countHit 로드 성공");
		countRead = preparedStatement.executeUpdate(); //실행 -> countRead에 담기
		System.out.println("쿼리 후 조회수: " + countRead);
		
		}catch(Exception e) {
		System.out.println("countHit 로드 실패");
		e.printStackTrace();
		}finally{
			try {
				if(preparedStatement !=null) preparedStatement.close();
				if(connection !=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();	
			}
		
		}//finally
	return countRead;
}//countView end 
	
}//end
