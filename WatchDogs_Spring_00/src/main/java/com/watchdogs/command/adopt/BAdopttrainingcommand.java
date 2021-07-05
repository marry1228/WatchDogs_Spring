package com.watchdogs.command.adopt;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.BDaoAdopt;
import com.watchdogs.dto.BDtoAdopt;

public class BAdopttrainingcommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int pageSize = 10; // 한 페이지에 출력할 게시물수 
		
		String adoptst = null ;
		
		if(adoptst == null) {
			adoptst ="훈련중";
		}

		
		String pageNum = request.getParameter("pageNum"); 	// 처음에 화면이 켜지기 전 즉 페이지 넘값이 넘어오기전에 초기 값이 있어야한다	
		if (pageNum == null){ // 클릭한게 없으면 1번 페이지
			pageNum = "1";
		}
	    int currentPage = Integer.parseInt(pageNum);
	    
	    // 해당 페이지에서 시작할 레코드 / 마지막 레코드
	    int startRow = (currentPage - 1) * pageSize + 1; //해당페이지에서 시작할 게시물
	    int endRow = pageSize;              // 해당페이지 마지막 게시물
	 
	    BDaoAdopt daoadopt = new BDaoAdopt();
	    HttpSession session = request.getSession();
	    
	    ArrayList<BDtoAdopt> dtos = daoadopt.adopttraining(startRow, endRow); // 해당 페이지에 알맞은 번호의 게시글
		
	     int count = daoadopt.getcount(adoptst);  // 총 게시물 가져오기

	        
	     System.out.println(count);
	    
	     session.setAttribute("count", count);
	 
	     request.setAttribute("count", count); // 결과!
	    request.setAttribute("adopt", dtos); // 결과!
		
		
		if(count > 0){
			// 총 페이지의 수
			int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
			// 한 페이지에 보여줄 페이지 블럭(링크) 수
			int pageBlock = 10;
			// 한 페이지에 보여줄 시작 및 끝 번호(예 : 1, 2, 3 ~ 10 / 11, 12, 13 ~ 20)
			int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
			int endPage = startPage + pageBlock - 1;
			
			// 마지막 페이지가 총 페이지 수 보다 크면 endPage를 pageCount로 할당
			if(endPage > pageCount){
				endPage = pageCount;
			}
			  session.setAttribute("pageCount", pageCount);
			  session.setAttribute("startPage", startPage);
			  session.setAttribute("endPage", endPage);
			
			System.out.println("총페이지수"+ pageCount);
			System.out.println("페이지 끝"+ endPage);
			System.out.println("시작 페이지"+ startPage);
		}
		}
		
		
//
//		BDaoAdopt daoadopt = new BDaoAdopt();
//		ArrayList<BDtoAdopt> dtosadopt = daoadopt.adopttraining();
//  
//        request.setAttribute("adopt", dtosadopt);
	}


