package com.watchdogs.command.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BHomeCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String str = "";
		
		HttpSession hsession = request.getSession(true);
		hsession.setAttribute("userid", str); // session 초기화
		hsession.setAttribute("usertype", str); // session 초기화
	}

}
