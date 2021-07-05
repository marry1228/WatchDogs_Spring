package com.watchdogs.command.admin_trainer;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoTrainer;
import com.watchdogs.dto.DtoTrainer;

public class TrainerUpdateOpenCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String trId = request.getParameter("trId");
		DaoTrainer daoTrainer = new DaoTrainer();
		DtoTrainer dto = daoTrainer.detail(trId);
		
		request.setAttribute("detail", dto);
		
		
		
	}

}
