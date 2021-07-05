package com.watchdogs.command.admin_trainer;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoTrainer;

public class TrainerInsertCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	  	String path = request.getSession().getServletContext().getRealPath("trainer"); 
		
		/* String path = request.getRealPath("fileFolder"); */
	 	//String path = request.getRealPath(“save”);
	  	
	 	System.out.println("trainer 접근 완료");
	  	
	  	int size = 1024 * 1024 * 10; // 업로드 할 최대 파일 크기 (몇 메가바이트까지인지)
	  	String trFilePath = ""; // 업로드 한 파일의 이름(이름이 변경될수 있다)
	  	String originalFile = ""; // 이름이 변경되기 전 실제 파일 이름 (옛날께 이름바꿨다고 삭제 되지 않게)
		// 실제 파일 업로드하는 과정
	  	try{
	    	MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
			//실제 path, max size, defaulFileRenamePolicy : 오리지날파일 어떻게 하겠느냐 : 파일뒤에 1,2 3 붙음 (덮어씌우기 방지 )
			//파일 이름 가져오기
	    	String trId = multi.getParameter("trId");
	    	String trPw = multi.getParameter("trPw");
	    	String trEmail = multi.getParameter("trEmail");
	    	String trTel = multi.getParameter("trTel");
	    	String trName = multi.getParameter("trName");
	    	String trCareer = multi.getParameter("trCareer");
	    	String adminID = multi.getParameter("adminID");
	    	
	    	DaoTrainer daoTrainer = new DaoTrainer();
	    	
	    	Enumeration files = multi.getFileNames();
	    	String str = (String)files.nextElement(); // 파일 이름을 받아와 string으로 저장
	    	trFilePath = multi.getFilesystemName(str); // 업로드 된 파일 이름 가져옴
	    	originalFile = multi.getOriginalFileName(str); // 원래의 파일이름 가져옴
	    	
	    	System.out.println(trFilePath);
	    	System.out.println(originalFile);
	    	
	    	daoTrainer.insert(trId, trPw, trEmail, trTel, trName, trCareer, trFilePath, adminID);
	    	
		} catch (Exception e) {
	    	e.printStackTrace();
		}
	  	
	
	
	
	
	
	}

}
