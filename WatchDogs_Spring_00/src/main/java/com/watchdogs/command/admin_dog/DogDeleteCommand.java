package com.watchdogs.command.admin_dog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoDog;
import com.watchdogs.dao.DaoTrainer;

public class DogDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int dogId = Integer.parseInt(request.getParameter("dogId"));
		
		DaoDog daoDog = new DaoDog();
		daoDog.delete(dogId);
	}

}
