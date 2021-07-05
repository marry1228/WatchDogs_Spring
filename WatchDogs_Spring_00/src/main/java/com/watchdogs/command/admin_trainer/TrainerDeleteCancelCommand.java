package com.watchdogs.command.admin_trainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoTrainer;

public class TrainerDeleteCancelCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String trId = request.getParameter("trId");
		
		DaoTrainer daoTrainer = new DaoTrainer();
		daoTrainer.deletecancel(trId);
	}

}
