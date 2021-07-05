package com.watchdogs.command.admin_user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoUser;

public class UserDeleteCancelCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		
		DaoUser daoUser = new DaoUser();
		daoUser.deletecancel(userId);
	}

}
