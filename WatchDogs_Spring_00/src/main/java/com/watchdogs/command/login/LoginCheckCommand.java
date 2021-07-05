package com.watchdogs.command.login;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.BListDao;
import com.watchdogs.dao.LoginCheckDao;
import com.watchdogs.dto.BListDto;
import com.watchdogs.dto.BLoginCheckDto;

public class LoginCheckCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");

		
		LoginCheckDao bLCDao = new LoginCheckDao();
		String result = bLCDao.logincheck(userId, userPw);		
		
		HttpSession hSession = request.getSession(true); // session에 아이디 값 설정
		hSession.setAttribute("result", result);
	}
}
