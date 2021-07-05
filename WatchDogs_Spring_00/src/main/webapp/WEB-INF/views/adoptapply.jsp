<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
      <%
       int dogid = Integer.parseInt(request.getParameter("dogid"));
      
       String url_mysql="jdbc:mysql://localhost:3306/watchdogs_test_03?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
       String id_mysql = "root";
       String pw_mysql = "qwer1234";
       
       PreparedStatement ps = null;
		
		String query = "update dog set dogadoptst=? where dogid = " +dogid+";";		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			// 자료 수정 업데이트
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, "입양진행중");		// tfName에 
			
			//입력된 텍스트 1번 자리에 설정
			
			ps.executeUpdate();	// sql 자료 업데이트 실행
			
			conn_mysql.isClosed();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();	// 화면에 에러 코드를 보여줘라
		}
	
       
       
   
       
       
       
       
       
       
       
		response.sendRedirect("adopt.wd");
       
       
      %>
      
	
</body>
</html>