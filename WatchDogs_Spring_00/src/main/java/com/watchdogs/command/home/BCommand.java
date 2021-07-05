package com.watchdogs.command.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand { // 메소드 이름만 정의 ; 회사마다 포맷이 틀리다. 처음에 팀별로 잘 정하기

	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
