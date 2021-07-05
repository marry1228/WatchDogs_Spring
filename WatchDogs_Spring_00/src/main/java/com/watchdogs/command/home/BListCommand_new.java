package com.watchdogs.command.home;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.watchdogs.dao.IDao_new;

public class BListCommand_new implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		IDao_new dao = sqlSession.getMapper(IDao_new.class);
		model.addAttribute("list", dao.listDao());
	}

}
