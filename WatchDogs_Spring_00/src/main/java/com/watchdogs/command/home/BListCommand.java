package com.watchdogs.command.home;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.dao.BListDao;
import com.watchdogs.dto.BListDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// DB에서 전체정보 읽어서 attribute로 jsp에 전달하기

			BListDao bDao = new BListDao();
			ArrayList<BListDto> dtos = bDao.list();
			
			request.setAttribute("list", dtos);
			
	}

}
