package com.watchdogs.command.admin_user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoTrainer;
import com.watchdogs.dao.DaoUser;

public class UserInsertCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userTel = request.getParameter("userTel");
		String userEmail = request.getParameter("userEmail");
		String userName = request.getParameter("userName");
		
		DaoUser daoUser = new DaoUser();
		daoUser.insert(userId, userPw, userTel, userEmail, userName);
	}

}
