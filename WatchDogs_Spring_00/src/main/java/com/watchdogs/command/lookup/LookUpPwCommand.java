package com.watchdogs.command.lookup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoLookupPw;
import com.watchdogs.dao.DaoTrainer;
import com.watchdogs.dao.DaoUser;

public class LookUpPwCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String userpwquiz = request.getParameter("userpwquiz");

		DaoLookupPw daolookuppw = new DaoLookupPw();
		String searchedPw = daolookuppw.lookuppw(userid, userpwquiz);
		
		HttpSession hSession = request.getSession(true); // session에 아이디 값 설정
		hSession.setAttribute("lookupresult", searchedPw);
		

	}

}
