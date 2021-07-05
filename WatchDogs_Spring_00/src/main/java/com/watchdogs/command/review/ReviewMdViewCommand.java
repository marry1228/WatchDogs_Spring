package com.watchdogs.command.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.ReviewDao;
import com.watchdogs.dto.ReviewDto;

public class ReviewMdViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("ReviewDetailViewCommand 성공");
		
		String reid = request.getParameter("reid");
		
		ReviewDao dao = new ReviewDao();
		
		System.out.println(reid);
		ReviewDto dto = dao.reviewDetail(reid);	
		request.setAttribute("reviewdetail", dto);
		
		
		
			
	}

	

}
