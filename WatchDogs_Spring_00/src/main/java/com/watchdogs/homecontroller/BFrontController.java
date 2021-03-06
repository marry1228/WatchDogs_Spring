package com.watchdogs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.watchdogs.command.admin.AdminPageOpenCommand;
import com.watchdogs.command.admin_trainer.TrainerPageOpenCommand;
import com.watchdogs.command.admin_user.UserPageOpenCommand;
import com.watchdogs.command.admin_user.UserDeleteCancelCommand;
import com.watchdogs.command.admin_notice.NoticeDeleteCancelCommand;
import com.watchdogs.command.admin_notice.NoticeDeleteCommand;
import com.watchdogs.command.admin_notice.NoticeInsertCommand;
import com.watchdogs.command.admin_notice.NoticeUpdateCommand;
import com.watchdogs.command.admin_notice.NoticeUpdateOpenCommand;
import com.watchdogs.command.admin_review.ReviewDeleteCommandInAdmin;
import com.watchdogs.command.admin_review.ReviewDeleteCancelCommandInAdmin;
import com.watchdogs.command.admin_review.ReviewInsertCommand;
import com.watchdogs.command.admin_review.ReviewUpdateCommand;
import com.watchdogs.command.admin_review.ReviewUpdateOpenCommand;
import com.watchdogs.command.admin_dog.DogDeleteCommand;
import com.watchdogs.command.admin_dog.DogDeleteCancelCommand;
import com.watchdogs.command.admin_dog.DogInsertCommand;
import com.watchdogs.command.admin_dog.DogUpdateCommand;
import com.watchdogs.command.admin_dog.DogUpdateOpenCommand;
import com.watchdogs.command.admin_trainer.TrainerDeleteCommand;
import com.watchdogs.command.admin_trainer.TrainerDeleteCancelCommand;
import com.watchdogs.command.admin_trainer.TrainerInsertCommand;
import com.watchdogs.command.admin_trainer.TrainerUpdateCommand;
import com.watchdogs.command.admin_trainer.TrainerUpdateOpenCommand;
import com.watchdogs.command.admin_user.UserDeleteCommand;
import com.watchdogs.command.admin_user.UserInsertCommand;
import com.watchdogs.command.admin_user.UserUpdateCommand;
import com.watchdogs.command.admin_user.UserUpdateOpenCommand;
import com.watchdogs.command.adopt.BAdoptSearchcommand;
import com.watchdogs.command.adopt.BAdoptcommand;
import com.watchdogs.command.adopt.BAdoptcomplete_02coammand;
import com.watchdogs.command.adopt.BAdoptcompletecoammand;
import com.watchdogs.command.adopt.BAdoptimginsertcommand;
import com.watchdogs.command.adopt.BAdoptproceeding_02command;
import com.watchdogs.command.adopt.BAdoptproceedingcommand;
import com.watchdogs.command.adopt.BAdopttrainingcommand;
import com.watchdogs.command.adopt.BAdopttrainingcommand_02;
import com.watchdogs.command.adopt.BAdoptwait_02command;
import com.watchdogs.command.home.BCommand;
import com.watchdogs.command.home.BHomeCommand;
import com.watchdogs.command.login.LoginCheckCommand;
import com.watchdogs.command.lookup.LookUpIdCommand;
import com.watchdogs.command.lookup.LookUpPwCommand;
import com.watchdogs.command.notice.NoticeDetailViewCommand;
import com.watchdogs.command.notice.NoticeListCommand;
import com.watchdogs.command.review.ReviewDeleteCommand;
import com.watchdogs.command.review.ReviewDetailViewCommand;
import com.watchdogs.command.review.ReviewListCommand;
import com.watchdogs.command.review.ReviewMdViewCommand;
import com.watchdogs.command.review.ReviewModifyCommand;
import com.watchdogs.command.review.ReviewWriteCommand;
import com.watchdogs.command.signup.SignUpCommand;
import com.watchdogs.command.admin_trainer.TrainerListOpenCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.wd")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			System.out.println("doGet");
			actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			System.out.println("doPost");
			actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	      request.setCharacterEncoding("UTF-8");
	      System.out.println("actionDo()");
	   
	      String uri = request.getRequestURI();        //   /MVCBoard/~
	      String conPath = request.getContextPath();   //   /MVCBoard
	      String com = uri.substring(conPath.length());//   /~
	      
	      String viewPage = null;
	      BCommand command = null;
	      
//	      System.out.println("getRequestURI = " + uri);
//	      System.out.println("getContextPath = " + conPath);
//	      System.out.println("URI = " + com); 
	      
	      switch(com) {
	      
//			--?????? ??????!	 
	      case("/home.wd"):  // ??? ??????, ?????? ?????????
				command = new BHomeCommand();
				command.execute(request, response);
				viewPage ="home.jsp";
				break;
				
//			--????????? ?????? ??????!			
	      case("/login.wd"):  // ????????? ??????
				viewPage ="login.jsp";
				break;
	      case("/logincheck.wd"):  // ????????? ?????? ??????
				command = new LoginCheckCommand();
				command.execute(request, response);
				
				HttpSession hsession = request.getSession(true);
				String result = (String)hsession.getAttribute("result");

				if(result.equals("successUser")) { // ?????? ????????? ?????? 
					hsession.setAttribute("userid", request.getParameter("userid"));
					hsession.setAttribute("usertype", "user");
					viewPage ="home.jsp";
				}else if (result.equals("successAdmin")){ // ????????? ????????? ??????
					hsession.setAttribute("userid", request.getParameter("userid"));
					hsession.setAttribute("usertype", "admin");
					viewPage ="home.jsp";
				} else{// ????????? ??????
					viewPage ="loginpop.jsp";
				}
				break;
				
	      case("/signup.wd"):  // ???????????? ??????
	    	  viewPage ="signup.jsp";
	      		break;
	      case("/signupfunction.wd"):  // ???????????? ??????
	    	  command = new SignUpCommand();
			    command.execute(request, response);
			    viewPage ="home.jsp";
			    break;	

	      case("/lookupidpw.wd"):  // ?????????,???????????? ?????? ?????????
	    	  	viewPage ="lookup.jsp";
	      		break;
	      case("/lookupidfunction.wd"):  // ????????? ?????? ??????
	    		command = new LookUpIdCommand();
				command.execute(request, response);
				
				hsession = request.getSession(true);
				String lookupresultid = (String)hsession.getAttribute("lookupresult");

				if(lookupresultid.equals("")) { // ????????? ?????? ??????
					viewPage ="lookupfail.jsp";
				}else{ 	// ????????? ?????? ??????
					hsession.setAttribute("lookupresult", lookupresultid);
					viewPage ="lookupidpop.jsp";					
				} 
				break;
				
	      case("/lookuppwfunction.wd"):  // ???????????? ?????? ??????
	    	  	command = new LookUpPwCommand();
	      		command.execute(request, response);
	      		
	      		hsession = request.getSession(true);
				String lookupresultpw = (String)hsession.getAttribute("lookupresult");

				if(lookupresultpw.equals("")) { // ???????????? ?????? ??????
					viewPage ="lookupfail.jsp";
				}else{ 	// ???????????? ?????? ??????
					hsession.setAttribute("lookupresult", lookupresultpw);
					viewPage ="lookuppwpop.jsp";
					
				} 
				break;
	    
	      		
	      		
//			--????????? ?????? ???!	 
	      
	      		
	      		
//			--?????? ?????? ????????? ??????!

	      case("/introduction.wd"):  // ?????? ?????????
	    	  	viewPage ="introduction.jsp";
	      		break;	      
	      case("/adoptpage.wd"):  // ?????? ?????????
	    	  	viewPage ="adopt.wd";
	      		break;	      
	      case("/trainerlist.wd"):  // ????????? ????????? ?????????
	    	  	command = new TrainerListOpenCommand();
	      		command.execute(request, response);
	      		viewPage ="trainerList.jsp";
	      		break;	      		
	      case("/notice.wd"):  // ????????? ?????????
	    	  viewPage ="noticelist.wd";
	      		break;	      
	     
//				--?????? ?????? ????????? ???!
	      case("/userUpdateForUser.wd"):  // jy??????5/27
              	command = new UserUpdateCommand();
	      		command.execute(request, response);
	      		viewPage ="home.wd";
	      		break;
	      case("/userOut.wd"):  // jy??????5/27
        		command = new UserDeleteCommand();
        		command.execute(request, response);
        		viewPage ="logout.jsp";
        		break;
				
				
				
//				--????????? ????????? ??????!
	      
	      case("/reviewlist.wd"): // ????????? ?????? ?????????
			   command = new ReviewListCommand();
			   command.execute(request, response);
			   viewPage = "reviewlist.jsp";  
			   break;
	       case("/review.wd"):	//???????????? ?????? ????????? ?????????
				viewPage = "review_write.jsp";
				break;
	      case("/review_write.wd"): // ?????? ??? ?????? ?????? ????????????
				command = new ReviewWriteCommand();
				command.execute(request, response);
				viewPage = "reviewlist.wd"; 
				break;
	      case("/reviewdetail.wd"): // review??? detail ????????? ???????????? (?????? ?????? ?????????)
				command = new ReviewDetailViewCommand();
				command.execute(request, response);
				viewPage = "review_detailview.jsp";
				break;
		  	case("/reviewmodify.wd"): // ?????? ?????? ??????????????? ?????? ?????? ????????? ????????????
				command = new ReviewModifyCommand();
				command.execute(request, response);
				viewPage = "reviewlist.wd";
				break;	
		  	case("/review_mdview.wd")://??????????????? ??????
				command = new ReviewMdViewCommand();
				command.execute(request, response);
				viewPage = "review_mdview.jsp";
				break;
			case("/reviewdelete.wd"): // ?????? ?????? ??????????????? ?????? ?????? ????????? ????????????
				command = new ReviewDeleteCommand();
				command.execute(request, response);
				viewPage = "reviewlist.wd";
				break;
		  	
				
		  	case("/noticelist.wd"): // ?????? ?????? ??????
				   command = new NoticeListCommand();
				   command.execute(request, response);
				   viewPage = "noticelist.jsp";
				   break;
		  	case("/noticedetail.wd"): // ?????? ?????? ????????? ????????????
				command = new NoticeDetailViewCommand();
				command.execute(request, response);
				viewPage = "notice_detailview.jsp";
				break;

				
//				--????????? ????????? ???!
				
//				???????????????(?????????, ????????????, ??????)
		     case("/longintypecheck.wd"):  // longintypecheck ????????? 
		      		viewPage ="logintypecheck.jsp";
	      			break;
		      case("/adminpage.wd"):  // admin ????????? 
		    	  	command = new AdminPageOpenCommand();
		      		command.execute(request, response);
	      			viewPage ="adminpage.jsp";
	      			break;
		      case("/trainerpage.wd"):  // trainer ????????? 
		    	  	command = new TrainerPageOpenCommand();
		      		command.execute(request, response);
	      			viewPage ="trainerpage.jsp";
	      			break;
		      case("/userpage.wd"):  // user ????????? 
		    	  	command = new UserPageOpenCommand();
		      		command.execute(request, response);
					viewPage ="userpage.jsp";
					break;				
	      
	      
//			--???????????? ????????? ??????!

	  	 case("/trainerUpdateOpen.wd"):  
	    	  	command = new TrainerUpdateOpenCommand();
	      		command.execute(request, response);
	      		viewPage ="trainerUpdate.jsp";
	      		break;
	      case("/trainerUpdate.wd"):  
	    	  	command = new TrainerUpdateCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
    			break;
	      case("/trainerInsertOpen.wd"):  
	      		viewPage ="trainerInsert.jsp";
	      		break;
	      case("/trainerInsert.wd"):  
	    	  	command = new TrainerInsertCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
    			break;
	      case("/trainerDelete.wd"):  
	    	  	command = new TrainerDeleteCommand();
	      		command.execute(request, response);
    			viewPage ="adminpage.wd";
    			break;
	      case("/trainerDeleteCancel.wd"):  
	    	  	command = new TrainerDeleteCancelCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
    			
//    			--???????????? ????????? ???!
    			
    			
		
//    			-- ?????????_????????? ?????? ?????? ??????! 			
	      case("/dogUpdateOpen.wd"):  
	    	  	command = new DogUpdateOpenCommand();
	      		command.execute(request, response);
	      		viewPage ="dogUpdate.jsp";
	      		break;
	      case("/dogUpdate.wd"):  
	    	  	command = new DogUpdateCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
	      case("/dogInsertOpen.wd"):  
	    	  	viewPage ="dogInsert.jsp";
	      		break;
	      case("/dogInsert.wd"):  
	    	  	command = new DogInsertCommand();
	      		command.execute(request, response);
  			viewPage ="adminpage.wd";
  			break;
	      case("/dogDelete.wd"):  
	    	  	command = new DogDeleteCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
	      case("/dogDeleteCancel.wd"):  
	    	  	command = new DogDeleteCancelCommand();
	      		command.execute(request, response);
				viewPage ="adminpage.wd";
				break;
//    			-- ?????????_????????? ?????? ?????? ???! 		      		
	      		
//    			-- ?????????_?????????(??????, ??????) ?????? ?????? ??????! 		      		// jy??????5/24
	      case("/noticeUpdateOpen.wd"):  
	    	  	command = new NoticeUpdateOpenCommand();
	      		command.execute(request, response);
	      		viewPage ="noticeUpdate.jsp";
	      		break;
	      case("/noticeUpdate.wd"):  
	    	  	command = new NoticeUpdateCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
	      case("/noticeInsertOpen.wd"):  
	    	  	viewPage ="noticeInsert.jsp";
	      		break;
	      case("/noticeInsert.wd"):  
	    	  	command = new NoticeInsertCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
	      case("/noticeDelete.wd"):  
	    	  	command = new NoticeDeleteCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
	      case("/noticeDeleteCancel.wd"):  
	    	  	command = new NoticeDeleteCancelCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
	      		
	      		
	   // ????????? ??????   		
	      case("/reviewUpdateOpen.wd"):  
	    	  	command = new ReviewUpdateOpenCommand();
	      		command.execute(request, response);
      			viewPage ="reviewUpdate.jsp";
      			break;
	      case("/reviewUpdate.wd"):  
	    	  	command = new ReviewUpdateCommand();
	      		command.execute(request, response);
      			viewPage ="adminpage.wd";
      			break;
	      case("/reviewInsertOpen.wd"):  
	    	  	viewPage ="reviewInsert.jsp";
	      		break;
	      case("/reviewInsert.wd"):  
	    	  	command = new ReviewInsertCommand();
	      		command.execute(request, response);
      			viewPage ="adminpage.wd";
      			break;
	      case("/reviewDeleteInAdmin.wd"):  
	    	  	command = new ReviewDeleteCommandInAdmin();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
	      case("/reviewDeleteCancelInAdmin.wd"):  
	    	  	command = new ReviewDeleteCancelCommandInAdmin();
	      		command.execute(request, response);
      			viewPage ="adminpage.wd";
      			break;
//    			-- ?????????_?????????(??????, ??????) ?????? ?????? ???! 		      		
      		
	      		
//    			-- ?????????_?????? ?????? ?????? ??????! 		 
	      case("/userUpdateOpen.wd"):  
	    	  	command = new UserUpdateOpenCommand();
	      		command.execute(request, response);
	      		viewPage ="userUpdate.jsp";
	      		break;
	      case("/userUpdate.wd"):  
	    	  	command = new UserUpdateCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
	      case("/userInsertOpen.wd"):  
	    	  	viewPage ="userInsert.jsp";
	      		break;
	      case("/userInsert.wd"):  
	    	  	command = new UserInsertCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
	      case("/userDelete.wd"):  
	    	  	command = new UserDeleteCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
	      case("/userDeleteCancel.wd"):  
	    	  	command = new UserDeleteCancelCommand();
	      		command.execute(request, response);
	      		viewPage ="adminpage.wd";
	      		break;
//    			-- ?????????_?????? ?????? ?????? ???!      		
	    

	      		
//	      		-- ?????? ????????? ??????!
	      case("/adopt.wd") :     // ?????? ???????????? ?????? ??????????????????
	      	  command = new BAdoptcommand() ;
	      	  viewPage = "adoptwait.jsp";
	          command.execute(request, response);
	          break;	          
	      case("/adoptwait_02.wd") :   // ?????????????????? ?????? ????????? ????????????
		      command = new BAdoptwait_02command() ;
		      viewPage = "adoptwait_02.jsp";
		      command.execute(request, response);
		      break;
	      case("/adoptapply.wd") :    // ?????? ????????? ???????????? ???????????? ????????????
		      command = new BAdoptcommand() ;
		      viewPage = "adoptapply.jsp";
		      command.execute(request, response);
		      break;
	      case("/adoptcomplete.wd") :                    // ?????????????????? ?????? ????????? ????????????
	    	  command = new BAdoptcompletecoammand() ;
		      viewPage = "adoptcomplete.jsp";
		      command.execute(request, response);
		      break;	      
	      case("/adoptcomplete_02.wd") :   // ?????????????????? ?????? ????????? ????????????
		      command = new BAdoptcomplete_02coammand() ;
		      viewPage = "adoptcomplete_02.jsp";
		      command.execute(request, response);
		      break;
	      case("/adoptproceeding.wd") :                 // ?????????????????? ?????? ????????? ????????????
		      command = new BAdoptproceedingcommand() ;
		      viewPage = "adoptproceeding.jsp";
		      command.execute(request, response);
		      break;
	      case("/adoptproceeding_02.wd") :                 // ?????????????????? ?????? ????????? ????????????
	    	  command = new BAdoptproceeding_02command() ;
		      viewPage = "adoptproceeding_02.jsp";
		      command.execute(request, response);
		      
		      break;	
	      case("/adopttraining.wd") :                 // ?????????????????? ?????? ???
	    	  command = new BAdopttrainingcommand() ;
	          viewPage = "adopttraining.jsp";
	         command.execute(request, response);
	      break; 
	      case("/adopttraining_02.wd") :                 // ?????????????????? ?????? ???  ????????? ????????????
		      command = new BAdopttrainingcommand_02() ;
		      viewPage = "adopttraining_02.jsp";
		      command.execute(request, response);
	      break;
	      case("/adoptwaitSearch.wd") :                 // ?????????????????? ?????? ??????
	    	  command = new BAdoptSearchcommand();
		      viewPage = "adoptwait.jsp";
		      command.execute(request, response);
	      break;
	      case("/adoptproceedingSearch.wd") :                 // ?????????????????? ?????? ??????
	    	  command = new BAdoptSearchcommand();
		      viewPage = "adoptproceeding.jsp";
		      command.execute(request, response);
	      break;
	      case("/adoptcompleteSearch.wd") :                 // ?????????????????? ?????? ??????
	    	  command = new BAdoptSearchcommand();
		      viewPage = "adoptcomplete.jsp";
		      command.execute(request, response);
	      break;
	      case("/adopttrainingSearch.wd") :                 // ?????????????????? ?????? ??? ??????
	    	  command = new BAdoptSearchcommand();
		      viewPage = "adopttraining.jsp";
		      command.execute(request, response);
	      break;    
	      case("/adoptimginsert.wd") :                 // ????????? ???????????????
	    	  command = new BAdoptimginsertcommand();
		      viewPage = "adoptimginsert.jsp";
		      command.execute(request, response);
	      break;
//	      		-- ?????? ????????? ???!
		    
	      }
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	      dispatcher.forward(request, response);
	   }

}
