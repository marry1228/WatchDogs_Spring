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
	
	String userid = (String)session.getAttribute("userid");
	String usertype = (String)session.getAttribute("usertype");
	session.getAttribute("userid");
	
	out.println("ID = " + userid);
	out.println("type = " + usertype);


	if(usertype.equals("admin")){
		response.sendRedirect("adminpage.wd");
	}else if(usertype.equals("trainer")){
		response.sendRedirect("trainerpage.wd");
	}else if(usertype.equals("user")){
		response.sendRedirect("userpage.wd");
	}else{
		response.sendRedirect("login.wd");
		
	}
	

%>
</body>
</html>