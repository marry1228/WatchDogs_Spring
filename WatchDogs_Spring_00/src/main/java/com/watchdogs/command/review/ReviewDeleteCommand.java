package com.watchdogs.command.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.ReviewDao;

public class ReviewDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//docid는 삭제하지 않지만 참조값
			String reid = request.getParameter("reid");
		
			ReviewDao dao = new ReviewDao();
			dao.reviewDelete(reid);
		

	}

}
