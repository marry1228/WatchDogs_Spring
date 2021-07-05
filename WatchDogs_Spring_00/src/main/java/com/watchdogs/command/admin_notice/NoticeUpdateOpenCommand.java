package com.watchdogs.command.admin_notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoNotice;
import com.watchdogs.dao.DaoDog;
import com.watchdogs.dto.DtoNotice;
import com.watchdogs.dto.DtoDog;

public class NoticeUpdateOpenCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int noId = Integer.parseInt(request.getParameter("noId"));
		DaoNotice daoNotice = new DaoNotice();
		DtoNotice dto = daoNotice.detail(noId);
		
		request.setAttribute("detail", dto);
	}

}
