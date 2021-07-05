package com.watchdogs.command.admin_dog;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoDog;
import com.watchdogs.dao.DaoTrainer;

public class DogInsertCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String path = request.getSession().getServletContext().getRealPath("dog"); 
		
		/* String path = request.getRealPath("fileFolder"); */
	 	//String path = request.getRealPath(“save”);
	  	
	 	System.out.println("dog 접근 완료");
	  	
	  	int size = 1024 * 1024 * 10; // 업로드 할 최대 파일 크기 (몇 메가바이트까지인지)
	  	String dogFilePath = ""; // 업로드 한 파일의 이름(이름이 변경될수 있다)
	  	String originalFile = ""; // 이름이 변경되기 전 실제 파일 이름 (옛날께 이름바꿨다고 삭제 되지 않게)
		// 실제 파일 업로드하는 과정
	  	try{
	    	MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
			//실제 path, max size, defaulFileRenamePolicy : 오리지날파일 어떻게 하겠느냐 : 파일뒤에 1,2 3 붙음 (덮어씌우기 방지 )
			//파일 이름 가져오기

	    	String dogName = multi.getParameter("dogName");
	    	String dogType = multi.getParameter("dogType");
	    	String dogMF = multi.getParameter("dogMF");
	    	String dogAge = multi.getParameter("dogAge");
	    	String adminID = multi.getParameter("adminID");
	    	String trainerID = multi.getParameter("trainerID");
	    	
	    	DaoDog daoDog = new DaoDog();
	    	
	    	Enumeration files = multi.getFileNames();
	    	String str = (String)files.nextElement(); // 파일 이름을 받아와 string으로 저장
	    	dogFilePath = multi.getFilesystemName(str); // 업로드 된 파일 이름 가져옴
	    	originalFile = multi.getOriginalFileName(str); // 원래의 파일이름 가져옴
	    	
	    	System.out.println(dogFilePath);
	    	System.out.println(originalFile);
	    	
	    	daoDog.insert(dogName, dogType, dogMF, dogAge, adminID, trainerID, dogFilePath);
	    	
		} catch (Exception e) {
	    	e.printStackTrace();
		}
	}

}