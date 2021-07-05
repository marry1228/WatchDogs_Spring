package com.watchdogs.command.adopt;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.BDaoAdopt;
import com.watchdogs.dto.BDtoAdopt;

public class BAdopttrainingcommand_02 implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		 int dogid = Integer.parseInt(request.getParameter("dogid"));
		    BDaoAdopt daoadopt = new BDaoAdopt();
		    ArrayList<BDtoAdopt> dtosadopt = daoadopt.adopttraining_02(dogid);
		    
		    System.out.println("여기는 adoptproceeding_02 커멘드야");
		    request.setAttribute("adopt", dtosadopt);

	}

}
