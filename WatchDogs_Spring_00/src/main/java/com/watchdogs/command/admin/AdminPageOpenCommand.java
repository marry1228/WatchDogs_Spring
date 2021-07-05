package com.watchdogs.command.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoNotice;
import com.watchdogs.dao.DaoReview;
import com.watchdogs.dao.DaoDog;
import com.watchdogs.dao.DaoTrainer;
import com.watchdogs.dao.DaoUser;
import com.watchdogs.dto.DtoNotice;
import com.watchdogs.dto.DtoReview;
import com.watchdogs.dto.DtoDog;
import com.watchdogs.dto.DtoTrainer;
import com.watchdogs.dto.DtoUser;

public class AdminPageOpenCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// DB에서 전체정보 읽어서 attribute로 jsp에 전달하기

			DaoTrainer daoTrainer = new DaoTrainer();
			ArrayList<DtoTrainer> dtosTrainer = daoTrainer.list();
			
			System.out.println(" Id = " + dtosTrainer); // 테스트 용
			request.setAttribute("listTrainer", dtosTrainer);
			
			DaoDog daoDog = new DaoDog();
			ArrayList<DtoDog> dtosDog = daoDog.list();
			
			System.out.println(" Id = " + dtosDog); // 테스트 용
			request.setAttribute("listDog", dtosDog);
			
			DaoNotice daoNo = new DaoNotice();
			ArrayList<DtoNotice> dtosNotice = daoNo.list();
			
			System.out.println(" Id = " + dtosNotice); // 테스트 용
			request.setAttribute("listNotice", dtosNotice);
			
			DaoReview daoRe = new DaoReview();
			ArrayList<DtoReview> dtosReview = daoRe.list();
			
			System.out.println(" Id = " + dtosReview); // 테스트 용
			request.setAttribute("listReview", dtosReview);
			
			DaoUser daoUser = new DaoUser();
			ArrayList<DtoUser> dtosUser = daoUser.list();
			
			System.out.println(" Id = " + dtosUser); // 테스트 용
			request.setAttribute("listUser", dtosUser);
			
	}

}
