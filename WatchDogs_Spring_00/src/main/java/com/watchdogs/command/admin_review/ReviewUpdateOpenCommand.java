package com.watchdogs.command.admin_review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoReview;
import com.watchdogs.dao.DaoTrainer;
import com.watchdogs.dto.DtoReview;
import com.watchdogs.dto.DtoTrainer;

public class ReviewUpdateOpenCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int reId = Integer.parseInt(request.getParameter("reId"));
		DaoReview daoReview = new DaoReview();
		DtoReview dto = daoReview.detail(reId);
		
		request.setAttribute("detail", dto);
	}

}
