package com.watchdogs.command.admin_notice;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoNotice;
import com.watchdogs.dao.DaoDog;

public class NoticeInsertCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String noTitle = request.getParameter("noTitle");
		String noContent = request.getParameter("noContent");
		String adminID = request.getParameter("adminID");
		
		DaoNotice daoDocument = new DaoNotice();
		daoDocument.insert(noTitle, noContent, adminID);
		
	}

}
