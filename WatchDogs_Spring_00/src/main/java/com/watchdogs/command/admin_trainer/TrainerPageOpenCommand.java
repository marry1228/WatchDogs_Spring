package com.watchdogs.command.admin_trainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoTrainer;
import com.watchdogs.dto.DtoTrainer;

public class TrainerPageOpenCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
	      
	    String trId = (String)session.getAttribute("userid");
		
		DaoTrainer daoTrainer = new DaoTrainer();
		DtoTrainer dto = daoTrainer.detail(trId);
		
		request.setAttribute("detail", dto);
	}

}
