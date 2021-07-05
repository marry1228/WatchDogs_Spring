package com.watchdogs.command.admin_notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoNotice;
import com.watchdogs.dao.DaoDog;

public class NoticeUpdateCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int noId = Integer.parseInt(request.getParameter("noId"));
		String noTitle = request.getParameter("noTitle");
		String noContent = request.getParameter("noContent");
		String noDate = request.getParameter("noDate");
		String noDelDate = request.getParameter("noDelDate");
		int noHit = Integer.parseInt(request.getParameter("noHit"));
		String adminID = request.getParameter("adminID");
		
		DaoNotice daoNotice = new DaoNotice();
		daoNotice.update(noId, noTitle, noContent, noDate, noDelDate, noHit, adminID);
	}

}
