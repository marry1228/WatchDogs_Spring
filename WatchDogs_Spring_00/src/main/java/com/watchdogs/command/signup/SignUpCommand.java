package com.watchdogs.command.signup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoUser;

public class SignUpCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		
		// TODO Auto-generated method stub
		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");
		String userTel = request.getParameter("usertel");
		String userEmail = request.getParameter("useremail");
		String userName = request.getParameter("username");
		
		DaoUser daoUser = new DaoUser();
		daoUser.insert(userId, userPw, userTel, userEmail, userName);
	}

}
