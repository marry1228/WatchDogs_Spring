package com.watchdogs.command.adopt;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.BDaoAdopt;
import com.watchdogs.dto.BDtoAdopt;

public class BAdoptwait_02command implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {  
		
	    int dogid = Integer.parseInt(request.getParameter("dogid"));
	    BDaoAdopt daoadopt = new BDaoAdopt();
	    ArrayList<BDtoAdopt> dtosadopt = daoadopt.adoptwait_02(dogid);

	    /////////////////////////////////////////////////////////////// 
//	    BDaoAdopt daoadopt2 = new BDaoAdopt();
//		ArrayList<BDtoAdopt> dtosadopt2 = daoadopt2.adoptwait_02(dogid);
	//////////////////////////////////////////////////////////////////
		
		
		
		
//		request.setAttribute("adoptwait_02trname", dtosadopt2);
	    request.setAttribute("adopt", dtosadopt);
	    
	    System.out.println("윤희지 여기는 커맨드입니다요" + dogid);
		}
	}
