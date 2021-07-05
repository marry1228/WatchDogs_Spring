package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.BDtoAdopt;

public class BDaoAdopt {
	private static BDaoAdopt instance = new BDaoAdopt();

	public static BDaoAdopt getInstance() {
		return instance;
	}

DataSource dataSource;

public BDaoAdopt() {
	
try {

Context context = new InitialContext();
dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");

}catch(Exception e) {
e.printStackTrace();
}
} 
//.............................................adoptwait 시작 부분
public ArrayList<BDtoAdopt> adoptwait(int startRow, int endRow) {
   if(startRow==1) {   // mysql은 0부터 시작이기 때문이다
	   startRow = 0;
	   }
ArrayList<BDtoAdopt> dtos = new ArrayList<BDtoAdopt>();     	   
   
Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;
try {

connection = dataSource.getConnection();

String query ="select dogid, dogname, dogmf, dogage, dogdate, dogtraincomm, dogadoptst, dogtype, dogfilepath, dogtrname from dog where dogadoptst like '입양가능' limit "+startRow+","+endRow+";";
preparedStatement = connection.prepareStatement(query);
resultSet = preparedStatement.executeQuery();
System.out.println(startRow+"이거는 시작게시물 숫자");
//int defpage = clickPage -1;
//preparedStatement.setInt(1, defpage * numInAPage); //여기에 그냥 요청 페이지를 넣으면 ? 안됨
//preparedStatement.setInt(2, numInAPage);
while(resultSet.next()) {
  
   int dogid = resultSet.getInt("dogid");
   String dogname = resultSet.getString("dogname");
   String dogtype = resultSet.getString("dogtype");
   String dogfilepath = resultSet.getString("dogfilepath");
   String dogage = resultSet.getString("dogage");
   String dogmf = resultSet.getString("dogmf");
   String dogadopttst = resultSet.getString("dogadoptst");
   String dogtraincomm = resultSet.getString("dogtraincomm");
   Timestamp dogdate = resultSet.getTimestamp("dogdate");
   String dogtrname = resultSet.getString("dogtrname");
   
  
   System.out.println(dogid);
   System.out.println("하하하");
   
   BDtoAdopt dtoadopt = new BDtoAdopt(dogname, dogadopttst,dogtraincomm,dogtrname,dogmf,dogage,dogfilepath,dogtype,dogid,dogdate);
   dtos.add(dtoadopt);
		   
}
   
}catch(Exception e) {
e.printStackTrace();

}finally {

try {
	  
if(resultSet !=null) resultSet.close();
if(preparedStatement !=null) resultSet.close();
if(connection !=null) resultSet.close();
connection.close();
  
}catch(Exception e) {
e.printStackTrace();
   
}
}
return dtos ;


} //......................................adoptwait 메소드 끝부분


//............................................. adoptproceeding 시작 부분
public ArrayList<BDtoAdopt> adoptproceeding(int startRow, int endRow) {

   if(startRow==1) {   // mysql은 0부터 시작이기 때문이다
	   startRow = 0;
	   }
   
   
ArrayList<BDtoAdopt> dtosadopt = new ArrayList<BDtoAdopt>();     	   
   
Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;

try {
   System.out.println("윤희지 = 여기는 adoptproceeding" + startRow); // 테스트용
   System.out.println("윤희지 = 여기는 adoptproceeding" + endRow); // 테스트용
    
   connection = dataSource.getConnection();

   String query ="select dogid, dogname, dogmf, dogage, dogdate, dogtraincomm, dogadoptst, dogtype, dogfilepath, dogtrname from dog where dogadoptst like '입양진행중' limit "+startRow+","+endRow+";";
   preparedStatement = connection.prepareStatement(query);
   resultSet = preparedStatement.executeQuery();
   

   while(resultSet.next()) {
	  
	   int dogid = resultSet.getInt("dogid");
	   String dogname = resultSet.getString("dogname");
	   String dogtype = resultSet.getString("dogtype");
	   String dogfilepath = resultSet.getString("dogfilepath");
	   String dogage = resultSet.getString("dogage");
	   String dogmf = resultSet.getString("dogmf");
	   String dogadopttst = resultSet.getString("dogadoptst");
	   String dogtraincomm = resultSet.getString("dogtraincomm");
	   Timestamp dogdate = resultSet.getTimestamp("dogdate");
	   String dogtrname = resultSet.getString("dogtrname");
	   
	  
	   
	   BDtoAdopt dtoadopt = new BDtoAdopt(dogname, dogadopttst,dogtraincomm,dogtrname,dogmf,dogage,dogfilepath,dogtype,dogid,dogdate);
	   dtosadopt.add(dtoadopt);
				   
}
   
}catch(Exception e) {
e.printStackTrace();

}finally {

try {
	  
if(resultSet !=null) resultSet.close();
if(preparedStatement !=null) resultSet.close();
if(connection !=null) resultSet.close();
connection.close();
  
}catch(Exception e) {
e.printStackTrace();
   
}
}
return dtosadopt ;


} //......................................adoptproceeding 메소드 끝부분



//............................................. adoptcomplete 시작 부분
public ArrayList<BDtoAdopt> adoptcomplete(int startRow, int endRow) {

if(startRow==1) {   // mysql은 0부터 시작이기 때문이다
startRow = 0;
}
   
ArrayList<BDtoAdopt> dtosadopt = new ArrayList<BDtoAdopt>();     	   
   
Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;

try {
    
   connection = dataSource.getConnection();

   String query ="select dogid, dogname, dogmf, dogage, dogdate, dogtraincomm, dogadoptst, dogtype, dogfilepath, dogtrname from dog where dogadoptst like '입양완료'limit "+startRow+","+endRow+";";
   preparedStatement = connection.prepareStatement(query);
   resultSet = preparedStatement.executeQuery();
   

   while(resultSet.next()) {
	  
	   int dogid = resultSet.getInt("dogid");
	   String dogname = resultSet.getString("dogname");
	   String dogtype = resultSet.getString("dogtype");
	   String dogfilepath = resultSet.getString("dogfilepath");
	   String dogage = resultSet.getString("dogage");
	   String dogmf = resultSet.getString("dogmf");
	   String dogadopttst = resultSet.getString("dogadoptst");
	   String dogtraincomm = resultSet.getString("dogtraincomm");
	   Timestamp dogdate = resultSet.getTimestamp("dogdate");
	   String dogtrname = resultSet.getString("dogtrname");
	   
	  
	   
	   BDtoAdopt dtoadopt = new BDtoAdopt(dogname, dogadopttst,dogtraincomm,dogtrname,dogmf,dogage,dogfilepath,dogtype,dogid,dogdate);
	   dtosadopt.add(dtoadopt);

   System.out.println("윤희지 = 여기는 adoptcomplete " + dtosadopt); // 테스트용
		   
}
   
}catch(Exception e) {
e.printStackTrace();

}finally {

try {
	  
if(resultSet !=null) resultSet.close();
if(preparedStatement !=null) resultSet.close();
if(connection !=null) resultSet.close();
connection.close();
  
}catch(Exception e) {
e.printStackTrace();
   
}
}
return dtosadopt ;


} //......................................adoptproceeding 메소드 끝부분



public ArrayList<BDtoAdopt> adopttraining(int startRow, int endRow) {
   
   if(startRow==1) {   // mysql은 0부터 시작이기 때문이다
	   startRow = 0;
	   }
   
   ArrayList<BDtoAdopt> dtosadopt = new ArrayList<BDtoAdopt>();     	   
	   
   Connection connection = null;
   PreparedStatement preparedStatement = null;
   ResultSet resultSet = null;
	
   try {
	    
	   connection = dataSource.getConnection();
	
	   String query ="select dogid, dogname, dogmf, dogage, dogdate, dogtraincomm, dogadoptst, dogtype, dogfilepath, dogtrname from dog where dogadoptst like '훈련중' limit "+startRow+","+endRow+";";
	   preparedStatement = connection.prepareStatement(query);
	   resultSet = preparedStatement.executeQuery();
	   
	  

	   while(resultSet.next()) {
		  
		   int dogid = resultSet.getInt("dogid");
		   String dogname = resultSet.getString("dogname");
		   String dogtype = resultSet.getString("dogtype");
		   String dogfilepath = resultSet.getString("dogfilepath");
		   String dogage = resultSet.getString("dogage");
		   String dogmf = resultSet.getString("dogmf");
		   String dogadopttst = resultSet.getString("dogadoptst");
		   String dogtraincomm = resultSet.getString("dogtraincomm");
		   Timestamp dogdate = resultSet.getTimestamp("dogdate");
		   String dogtrname = resultSet.getString("dogtrname");
	  
	   
		   BDtoAdopt dtoadopt = new BDtoAdopt(dogname, dogadopttst,dogtraincomm,dogtrname,dogmf,dogage,dogfilepath,dogtype,dogid,dogdate);
		   dtosadopt.add(dtoadopt);
	

			   
   }
	   
   }catch(Exception e) {
   e.printStackTrace();
   
   }finally {
	
   try {
		  
   if(resultSet !=null) resultSet.close();
   if(preparedStatement !=null) resultSet.close();
   if(connection !=null) resultSet.close();
   connection.close();
	  
   }catch(Exception e) {
   e.printStackTrace();
	   
   }
   }
   return dtosadopt ;
   
   
   } //......................................adoptproceeding 메소드 끝부분
   

//......................................adoptwait_02 메소드 시작부분

public ArrayList<BDtoAdopt> adoptwait_02(int strid) {
   
   ArrayList<BDtoAdopt> dtosadopt = new ArrayList<BDtoAdopt>();     	     // 강아지 정보
//   ArrayList<BDtoAdopt> dtosadopt2 = new ArrayList<BDtoAdopt>();             //훈련사  이름
   
   
////////////////////////////////////////////////////////////////
   
   Connection connection = null;
   PreparedStatement preparedStatement = null;                    //일반 정보를 얻기 위함
   ResultSet resultSet = null;
   

   
   
   try {

   connection = dataSource.getConnection();

   
   String query ="select dogid, dogname, dogmf, dogage, dogdate, dogtraincomm, dogadoptst, dogtype, dogfilepath, dogtrname from dog where dogid = ?;";
   preparedStatement = connection.prepareStatement(query);
   preparedStatement.setInt(1, strid);
   resultSet = preparedStatement.executeQuery();
   
   System.out.println("윤희지 = 여기는 테스트 제잘" + dtosadopt); // 테스트용

// 
	   
   if(resultSet.next()) {
	   int dogid = resultSet.getInt("dogid");
	   String dogname = resultSet.getString("dogname");
	   String dogtype = resultSet.getString("dogtype");
	   String dogfilepath = resultSet.getString("dogfilepath");
	   String dogage = resultSet.getString("dogage");
	   String dogmf = resultSet.getString("dogmf");
	   String dogadopttst = resultSet.getString("dogadoptst");
	   String dogtraincomm = resultSet.getString("dogtraincomm");
	   Timestamp dogdate = resultSet.getTimestamp("dogdate");
	   String dogtrname = resultSet.getString("dogtrname");
  
   
	   BDtoAdopt dtoadopt = new BDtoAdopt(dogname, dogadopttst,dogtraincomm,dogtrname,dogmf,dogage,dogfilepath,dogtype,dogid,dogdate);
	   dtosadopt.add(dtoadopt);


	   System.out.println("윤희지 = 여기는 adoptwait_02 " + dtosadopt); // 테스트용
			   
   
   }	   
   }catch(Exception e) {
   e.printStackTrace();
   
   }finally {
	
   try {
		  
   if(resultSet !=null) resultSet.close();
   if(preparedStatement !=null) resultSet.close();
   if(connection !=null) resultSet.close();
   connection.close();

	  
   }catch(Exception e) {
   e.printStackTrace();
	   
   }
   }
   return dtosadopt ;




}// ........................................ adoptwait_02 끝부분
// ........................................ adoptcomplete_02 시작 부분

public ArrayList<BDtoAdopt> adoptcomplete_02(int strid) {
   
   ArrayList<BDtoAdopt> dtosadopt = new ArrayList<BDtoAdopt>();     	   
	   
   Connection connection = null;
   PreparedStatement preparedStatement = null;
   ResultSet resultSet = null;
	
   try {

   connection = dataSource.getConnection();
 
   System.out.println("윤희지 = 여기는 bdo" + dtosadopt); // 테스트용

   String query ="select dogid, dogname, dogmf, dogage, dogdate, dogtraincomm, dogadoptst, dogtype, dogfilepath, dogtrname from dog where dogid = ?;";
   preparedStatement = connection.prepareStatement(query);
   preparedStatement.setInt(1, strid);
   resultSet = preparedStatement.executeQuery();
  
   if(resultSet.next()) {
	   int dogid = resultSet.getInt("dogid");
	   String dogname = resultSet.getString("dogname");
	   String dogtype = resultSet.getString("dogtype");
	   String dogfilepath = resultSet.getString("dogfilepath");
	   String dogage = resultSet.getString("dogage");
	   String dogmf = resultSet.getString("dogmf");
	   String dogadopttst = resultSet.getString("dogadoptst");
	   String dogtraincomm = resultSet.getString("dogtraincomm");
	   Timestamp dogdate = resultSet.getTimestamp("dogdate");
	   String dogtrname = resultSet.getString("dogtrname");
  
   
	   BDtoAdopt dtoadopt = new BDtoAdopt(dogname, dogadopttst,dogtraincomm,dogtrname,dogmf,dogage,dogfilepath,dogtype,dogid,dogdate);
	   dtosadopt.add(dtoadopt);

	   System.out.println("윤희지 = 여기는 adoptcomplete_02 " + dtosadopt); // 테스트용
			   
   }
	   
   }catch(Exception e) {
   e.printStackTrace();
   
   }finally {
	
   try {
		  
   if(resultSet !=null) resultSet.close();
   if(preparedStatement !=null) resultSet.close();
   if(connection !=null) resultSet.close();
   connection.close();
	  
   }catch(Exception e) {
   e.printStackTrace();
	   
   }
   }
   return dtosadopt ;
   
} // adoptcomplete_02 끝부분


//.................................. adoptproceeding_02 시작 부분
   public ArrayList<BDtoAdopt> adoptproceeding_02(int strid) {
   
   ArrayList<BDtoAdopt> dtosadopt = new ArrayList<BDtoAdopt>();     	   
	   
   Connection connection = null;
   PreparedStatement preparedStatement = null;
   ResultSet resultSet = null;
	
   try {

   connection = dataSource.getConnection();
 
   System.out.println("윤희지 = 여기는 bdo" + dtosadopt); // 테스트용

   String query ="select dogid, dogname, dogmf, dogage, dogdate, dogtraincomm, dogadoptst, dogtype, dogfilepath, dogtrname from dog where dogid = ?;";
   preparedStatement = connection.prepareStatement(query);
   preparedStatement.setInt(1, strid);
   resultSet = preparedStatement.executeQuery();
  
   if(resultSet.next()) {
	   int dogid = resultSet.getInt("dogid");
	   String dogname = resultSet.getString("dogname");
	   String dogtype = resultSet.getString("dogtype");
	   String dogfilepath = resultSet.getString("dogfilepath");
	   String dogage = resultSet.getString("dogage");
	   String dogmf = resultSet.getString("dogmf");
	   String dogadopttst = resultSet.getString("dogadoptst");
	   String dogtraincomm = resultSet.getString("dogtraincomm");
	   Timestamp dogdate = resultSet.getTimestamp("dogdate");
	   String dogtrname = resultSet.getString("dogtrname");
  
   
	   BDtoAdopt dtoadopt = new BDtoAdopt(dogname, dogadopttst,dogtraincomm,dogtrname,dogmf,dogage,dogfilepath,dogtype,dogid,dogdate);
	   dtosadopt.add(dtoadopt);


	   System.out.println("윤희지 = 여기는 adoptcomplete_02 " + dtosadopt); // 테스트용
			   
   }
	   
   }catch(Exception e) {
   e.printStackTrace();
   
   }finally {
	
   try {
		  
   if(resultSet !=null) resultSet.close();
   if(preparedStatement !=null) resultSet.close();
   if(connection !=null) resultSet.close();
   connection.close();
	  
   }catch(Exception e) {
   e.printStackTrace();
	   
   }
   }
   return dtosadopt ;
}//.....................................................adoptproceeding_02 끝부분
   
   //.................................. adoptproceeding_02 시작 부분
   public ArrayList<BDtoAdopt> adopttraining_02(int strid) {
   
   ArrayList<BDtoAdopt> dtosadopt = new ArrayList<BDtoAdopt>();     	   
	   
   Connection connection = null;
   PreparedStatement preparedStatement = null;
   ResultSet resultSet = null;
	
   try {

   connection = dataSource.getConnection();
 
   System.out.println("윤희지 = 여기는 bdo" + dtosadopt); // 테스트용

   String query ="select dogid, dogname, dogmf, dogage, dogdate, dogtraincomm, dogadoptst, dogtype, dogfilepath, dogtrname from dog where dogid = ?;";
   preparedStatement = connection.prepareStatement(query);
   preparedStatement.setInt(1, strid);
   resultSet = preparedStatement.executeQuery();
  
   if(resultSet.next()) {
	   int dogid = resultSet.getInt("dogid");
	   String dogname = resultSet.getString("dogname");
	   String dogtype = resultSet.getString("dogtype");
	   String dogfilepath = resultSet.getString("dogfilepath");
	   String dogage = resultSet.getString("dogage");
	   String dogmf = resultSet.getString("dogmf");
	   String dogadopttst = resultSet.getString("dogadoptst");
	   String dogtraincomm = resultSet.getString("dogtraincomm");
	   Timestamp dogdate = resultSet.getTimestamp("dogdate");
	   String dogtrname = resultSet.getString("dogtrname");
  
   
	   BDtoAdopt dtoadopt = new BDtoAdopt(dogname, dogadopttst,dogtraincomm,dogtrname,dogmf,dogage,dogfilepath,dogtype,dogid,dogdate);
	   dtosadopt.add(dtoadopt);


	   System.out.println("윤희지 = 여기는 adoptcomplete_02 " + dtosadopt); // 테스트용
			   
   }
	   
   }catch(Exception e) {
   e.printStackTrace();
   
   }finally {
	
   try {
		  
   if(resultSet !=null) resultSet.close();
   if(preparedStatement !=null) resultSet.close();
   if(connection !=null) resultSet.close();
   connection.close();
	  
   }catch(Exception e) {
   e.printStackTrace();
	   
   }
   }
   return dtosadopt ;
}//.....................................................adoptproceeding_02 끝부분

 //.....................................................dogimginsert  시작 부분
   
   
   public void dogimginsert(String dogname,String dogmf,String dogage,String dogtype,String dogtraincomm,String dogadopttst, String dogfilepath) {
	
	   Connection connection = null;
	   PreparedStatement preparedStatement = null;
	   ResultSet resultSet = null;
		
	   try {
    
	   connection = dataSource.getConnection();

	   
	   System.out.println(dogname);
	   System.out.println(dogmf);
	   System.out.println(dogage);
	   System.out.println(dogtype);
	   System.out.println(dogtraincomm);
	   System.out.println(dogadopttst);
	   System.out.println(dogfilepath);
      
	   String query = "insert into dog (dogname, dogmf, dogage, dogtype, dogtraincomm, dogadoptst, dogfilepath, dogdate) values (?, ?, ?, ?, ?, ?, ?, now())";
	  
	   preparedStatement = connection.prepareStatement(query);
	   
	   preparedStatement.setString(1, dogname);
	   preparedStatement.setString(2, dogmf);
	   preparedStatement.setString(3, dogage);
	   preparedStatement.setString(4, dogtype);
	   preparedStatement.setString(5, dogtraincomm);
	   preparedStatement.setString(6, dogadopttst);
	   preparedStatement.setString(7, dogfilepath);
	 
	   preparedStatement.executeUpdate();
	   
       }catch(Exception e) {
	   e.printStackTrace();
       }
       }
   
   //.................................. adoptsearch 시작 부분
   public ArrayList<BDtoAdopt> adoptsearch(String search, String searchtype, String searchdogadopttst) {
   
   ArrayList<BDtoAdopt> dtosadopt = new ArrayList<BDtoAdopt>();     	   
	   
   Connection connection = null;
   PreparedStatement preparedStatement = null;
   ResultSet resultSet = null;

 
	
   try {

   connection = dataSource.getConnection();
 
   

   String query ="select dogid, dogname, dogmf, dogage, dogdate, dogtraincomm, dogadoptst, dogtype, dogfilepath, dogtrname from dog where "+searchtype+" like '%"+search +"%' and dogadoptst like '%"+searchdogadopttst+"%';";
   preparedStatement = connection.prepareStatement(query);
 
   System.out.println(searchdogadopttst+"제발좀 알려줘라");
  
   
   resultSet = preparedStatement.executeQuery();
  
   while(resultSet.next()) {
	   int dogid = resultSet.getInt("dogid");
	   String dogname = resultSet.getString("dogname");
	   String dogtype = resultSet.getString("dogtype");
	   String dogfilepath = resultSet.getString("dogfilepath");
	   String dogage = resultSet.getString("dogage");
	   String dogmf = resultSet.getString("dogmf");
	   String dogadopttst = resultSet.getString("dogadoptst");
	   String dogtraincomm = resultSet.getString("dogtraincomm");
	   Timestamp dogdate = resultSet.getTimestamp("dogdate");
	   String dogtrname = resultSet.getString("dogtrname");
   
	   System.out.println(dogname);
   
	   BDtoAdopt dtoadopt = new BDtoAdopt(dogname, dogadopttst,dogtraincomm,dogtrname,dogmf,dogage,dogfilepath,dogtype,dogid,dogdate);
	   dtosadopt.add(dtoadopt);


	   System.out.println("윤희지 = 여기는 adoptcomplete_02 " + dtosadopt); // 테스트용
			   
   }
	   
   }catch(Exception e) {
   e.printStackTrace();
   
   }finally {
	
   try {
		  
   if(resultSet !=null) resultSet.close();
   if(preparedStatement !=null) resultSet.close();
   if(connection !=null) resultSet.close();
   connection.close();
	  
   }catch(Exception e) {
   e.printStackTrace();
	   
   }
   }
   return dtosadopt ;
}//.....................................................adoptsearch 끝부분

   
//.....................................................adopt 시작 부분

public int getcount(String adoptst) { //일반카테고리 카운트

System.out.println("맥스를 구하기위한 테스트입니다");

Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;

int count = 0;   

try {
connection = dataSource.getConnection();

String sql = "select count(*) from dog where dogadoptst like '"+adoptst+"';"; 


preparedStatement = connection.prepareStatement(sql);
resultSet = preparedStatement.executeQuery();

if(resultSet.next()){
	count = resultSet.getInt(1);
}
System.out.println(count +"이거는 숫자입니다");

}catch(Exception e) {
e.printStackTrace();
 
}finally {

try {
	  
if(resultSet !=null) resultSet.close();
if(preparedStatement !=null) resultSet.close();
if(connection !=null) resultSet.close();
connection.close();
  
}catch(Exception e) {
e.printStackTrace();
   
}
}
return count;
}       
   /////////////////////////////////////////////////////////////////////////////////////
public int searchcount(String search, String searchtype, String dogadoptst) { //일반카테고리 카운트

System.out.println("맥스를 구하기위한 테스트입니다");

Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;

int count = 0;   

try {
connection = dataSource.getConnection();

String sql = "select count(*) from dog where "+searchtype+" like '%"+search +"%' and dogadoptst like '%"+dogadoptst+"%';";

preparedStatement = connection.prepareStatement(sql);
resultSet = preparedStatement.executeQuery();

if(resultSet.next()){
	count = resultSet.getInt(1);
}
System.out.println(count +"이거는 숫자입니다");

}catch(Exception e) {
e.printStackTrace();
 
}finally {

try {
	  
if(resultSet !=null) resultSet.close();
if(preparedStatement !=null) resultSet.close();
if(connection !=null) resultSet.close();
connection.close();
  
}catch(Exception e) {
e.printStackTrace();
   
}
}
return count;
}       
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   //.....................................................adoptpage 끝부분 부분
   
   
   
   
   
   
}  // ........................................클라스 끝부분
        
