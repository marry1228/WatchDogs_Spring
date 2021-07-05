package com.watchdogs.command.admin_user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoUser;
import com.watchdogs.dto.DtoUser;

public class UserPageOpenCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		  HttpSession session = request.getSession(true);
	      
	      String userId = (String)session.getAttribute("userid");
	      
	      DaoUser daoUser = new DaoUser();
	      DtoUser dto = daoUser.detail(userId);
	      
	      request.setAttribute("detail", dto);
	}

}
