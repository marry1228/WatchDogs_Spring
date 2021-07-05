package com.watchdogs.command.admin_trainer;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoTrainer;
import com.watchdogs.dto.DtoTrainer;

public class TrainerListOpenCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DaoTrainer daoTrainer = new DaoTrainer();
		ArrayList<DtoTrainer> dtos = daoTrainer.currentlist();
		
		System.out.println(" Id = " + dtos); 
		request.setAttribute("list", dtos);
	}

}
