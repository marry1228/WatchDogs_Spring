package com.watchdogs.command.home;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BCommand_new {
	
	void execute(SqlSession sqlSession, Model model);

}
