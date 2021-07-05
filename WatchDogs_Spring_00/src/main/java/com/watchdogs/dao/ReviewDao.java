package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.ReviewDto;

public class ReviewDao {
	

	DataSource dataSource;
	
	public ReviewDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			System.out.println("Review DB연결 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Review DB연결 실패");
		}
	}
	
	
	//-------------------------------------------------------------HE part 
	/*
	 * 2021.05.17 권효은
	 * reviewWrite 메소드를 통해 DB에 게시판 내용 작성
	 * 2021.05.17 17:45 완성
	 */
	
	public void reviewWrite(String reid, String userid, String retitle, String recontent ,String refilepath) { //여기 메소드에서 아이디는  사용할 필요는 없다
		
		// 입력해둔 아이디가 하나있고, 그 아이디와 같아야 입력됨! (임시아이디)
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try { 
			connection = dataSource.getConnection();
			
			String query = "insert into review (retitle, recontent, redate, userid, refilepath) values (?, ?, now(), ?, ?)";
			
			preparedStatement = connection.prepareStatement(query);
			
			
			preparedStatement.setString(1, retitle);
			preparedStatement.setString(2, recontent);
			preparedStatement.setString(3, userid);
			preparedStatement.setString(4, refilepath);			
			
			preparedStatement.executeUpdate();
			
			System.out.println("reviewWrite 데이터 로드 성공");
		}catch(Exception e) {
			System.out.println("reviewWrite 데이터 로드 실패");
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

		
	}//review write 메소드 end
	
	/*
	 * 2021.05.17-18 권효은
	 * review 게시물 리스트 불러오기
	 * 05 19 페이징 추가 (현재 페이지,페이지 블락:한페이지 나올 수)
	 * 05.23 조건 검색 기능 추가 (콤보박스 선택 값, 검색한 단어)
	 */

	public ArrayList<ReviewDto> reviewList(int clickPage, int numInAPage, String searchCategory, String searchWord) {
		ArrayList<ReviewDto> list = new ArrayList<ReviewDto>();
		
		String query = "null"; 
		String query2 ="null";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		
		try {
			
			//limit에 한 페이지당 들어갈 게시물 갯수를 ?로 구현 
			//limit start 지점. 몇개 뽑을 건지
				
			if(searchCategory.equals("all"))
			{	
				query = "select reid, rehit, userid, retitle, recontent, redate, redeldate ";
				query2= "from review where redeldate is null and retitle like '%"+searchWord+"%' or recontent like '%"+searchWord+"%' order by reid desc limit ?, ?";
			}else if(searchCategory.equals("title")) {
				
				query = "select reid, rehit, userid, retitle, recontent, redate, redeldate ";
				query2 = "from review where retitle like '%"+searchWord+"%' and redeldate is null order by reid desc limit ?, ?";
				
			}else if(searchCategory.equals("content")) {
				
				query = "select reid, rehit, userid, retitle, recontent, redate, redeldate ";
				query2 = "from review where recontent like '%"+searchWord+"%' and redeldate is null order by reid desc limit ?, ?";

			}
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query+query2);
			
			int defpage = clickPage -1;
			preparedStatement.setInt(1, defpage * numInAPage); 
			//10(numInApage)개 기준이면 0에서 -> 0, 1 이 들어오면 10, 2가 들어오면 20 이렇게 되어야함 
			//즉 처음 물음표는 값이 계속 limit해 놓은 페이지 다음게 시작해야하므로  clickpage * numInApage 인데, 첫시작은 0인게 좋음
			preparedStatement.setInt(2, numInAPage);
			
			resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				int reid = resultSet.getInt(1);
				int rehit = resultSet.getInt(2);
				String userid = resultSet.getString(3);
				String retitle = resultSet.getString(4);
				String recontent = resultSet.getString(5);
				String redate = resultSet.getString(6);
				String redeldate = resultSet.getString(7);
				
				ReviewDto dto = new ReviewDto(reid, rehit, userid, retitle, recontent, redate, redeldate);
				list.add(dto); 
				System.out.println("reviewList 데이터 로드 성공");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("reviewList 데이터 로드 실패");
		}finally { 
			try {
				if(resultSet != null) resultSet.close(); 
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				System.out.println("reviewList 데이터 final 성공");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}//arraylist review list end
	

	
	/*
	 *  2021.05.18 권효은
	 *  review detail view 후기 상세 페이지
	 */
	public ReviewDto reviewDetail(String reid) {
		
		
		ReviewDto dto =null; //추가 새벽
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			String query = "select reid, userid, rehit, retitle, redate, recontent, refilepath from review where reid = ?"; 
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, Integer.parseInt(reid));  // ?인 것을 뭐로 하겠다! 
			
			resultSet = preparedStatement.executeQuery(); // 그 문장을 가지고 쿼리문을 실행한 값을 받아둠
			
			while(resultSet.next()) {
				
				int reId = resultSet.getInt(1); //추가 새벽
				String userid = resultSet.getString(2);
				int rehit = resultSet.getInt(3); //불러오는김에 히트도
				String retitle = resultSet.getString(4);
				String redate = resultSet.getString(5);
				String recontent = resultSet.getString(6);
				String refilepath = resultSet.getString(7);
				
				dto = new ReviewDto(reId, userid, rehit, retitle, redate, recontent,refilepath);
				System.out.println("reviewDetail 데이터 로드 성공");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("reviewDetail 데이터 로드 실패");
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
	
	}//reviewdetail end
	
	/*/
	 * 2021.05.18-19 권효은 
	 * 후기 수정
	 */
	public void reviewModify(String reid, String retitle, String recontent , String refilepath) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			//update때는 values가 안먹힐때 있음
			String query = "update review set retitle = ?, recontent = ? , refilepath = ? where reid = ? ";
			
			preparedStatement = connection.prepareStatement(query);
			
			//query문 안에 뭐넣을지 정해줌
			preparedStatement.setString(1, retitle);
			preparedStatement.setString(2, recontent);
			//이미지 수정을위해 파일경로 추가
			preparedStatement.setString(3, refilepath);
			//화면상의 String 인 문서번호를 인트값으로 바꿔주기 
			int temdocid = Integer.parseInt(reid);
			preparedStatement.setInt(4, temdocid);
			
			System.out.println("reviewModify 로드 성공");
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("reviewModify 로드 실패");
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

		
	}//reviewModify end
	
	/*/
	 * 2021.05.18 -19 권효은 
	 * 후기 삭제
	 */	
	//---------------------------------삭제 해보기

	public void reviewDelete(String reid) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			//완전 삭제가 아닌 게시물 삭제 날 저장으로 변경
			String query = "update review set redeldate = now() where reid= ?"; 
			
			preparedStatement = connection.prepareStatement(query);
			//날짜가 입력되도록 함
			preparedStatement.setInt(1, Integer.parseInt(reid));
			
			preparedStatement.executeUpdate();
			System.out.println("reviewDelete DB입력 성공");
			
		}catch(Exception e) {
			System.out.println("reviewDelete DB입력 실패");
			e.printStackTrace();
			//정상적이든, 에러가 걸리든 무조건 final로 와라 
		}finally{
			try {
				//close해줘야 데이터가 쌓이지 않음
				if(preparedStatement !=null) preparedStatement.close();
				if(connection !=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
		}

		
	}//reviewDelete end
	

		
	/*/
	 * 2021.05.19 권효은
	 * 페이지 총 목록 행의 갯수 구하기 (게시물 수)
	 */
	public int countTotalRows() {
		int count = 0;
	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//게시물에 있는 모든 게시물 갯수 가져오기
		String query = "select count(*) from review";  

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				count = resultSet.getInt(1);
				System.out.println("list count 성공");
			}
		}catch (Exception e) {
			System.out.println("list count 실패");
			e.printStackTrace();
		}finally { // 메모리에서 정리 
			try {
				// resultset이 비어있지 않으면, 정리한다. 
				if(resultSet != null) resultSet.close(); 
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				System.out.println("reviewList count 데이터 final 성공");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//finally

			return count;

	}//countlist end
			
		/*
		 * 2021.05. 19-20 권효은
		 * 	조회수 갯수 구해보기
		 */
		
	public int countHit(int reid) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		//조회수 저장공간
		int countRead = 0;
		try {
			String query = "update review set rehit = rehit + 1 where reid = ? " ;
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			
			//query문 안에 뭐넣을지 정해줌
			preparedStatement.setInt(1, reid);
			
			System.out.println("countViews 로드 성공");
			countRead = preparedStatement.executeUpdate(); //실행 -> countRead에 담기
			}catch(Exception e) {
			System.out.println("countViews 로드 실패");
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
	}//countHit end 
	
	
		
}//end
