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
	      
//			--메인 화면!	 
	      case("/home.wd"):  // 첫 화면, 메인 페이지
				command = new BHomeCommand();
				command.execute(request, response);
				viewPage ="home.jsp";
				break;
				
//			--로그인 기능 시작!			
	      case("/login.wd"):  // 로그인 화면
				viewPage ="login.jsp";
				break;
	      case("/logincheck.wd"):  // 로그인 중간 과정
				command = new LoginCheckCommand();
				command.execute(request, response);
				
				HttpSession hsession = request.getSession(true);
				String result = (String)hsession.getAttribute("result");

				if(result.equals("successUser")) { // 유저 로그인 성공 
					hsession.setAttribute("userid", request.getParameter("userid"));
					hsession.setAttribute("usertype", "user");
					viewPage ="home.jsp";
				}else if (result.equals("successAdmin")){ // 관리자 로그인 성공
					hsession.setAttribute("userid", request.getParameter("userid"));
					hsession.setAttribute("usertype", "admin");
					viewPage ="home.jsp";
				} else{// 로그인 실패
					viewPage ="loginpop.jsp";
				}
				break;
				
	      case("/signup.wd"):  // 회원가입 화면
	    	  viewPage ="signup.jsp";
	      		break;
	      case("/signupfunction.wd"):  // 회원가입 기능
	    	  command = new SignUpCommand();
			    command.execute(request, response);
			    viewPage ="home.jsp";
			    break;	

	      case("/lookupidpw.wd"):  // 아이디,비밀번호 찾기 페이지
	    	  	viewPage ="lookup.jsp";
	      		break;
	      case("/lookupidfunction.wd"):  // 아이디 찾기 기능
	    		command = new LookUpIdCommand();
				command.execute(request, response);
				
				hsession = request.getSession(true);
				String lookupresultid = (String)hsession.getAttribute("lookupresult");

				if(lookupresultid.equals("")) { // 아이디 찾기 실패
					viewPage ="lookupfail.jsp";
				}else{ 	// 아이디 찾기 실패
					hsession.setAttribute("lookupresult", lookupresultid);
					viewPage ="lookupidpop.jsp";					
				} 
				break;
				
	      case("/lookuppwfunction.wd"):  // 비밀번호 찾기 기능
	    	  	command = new LookUpPwCommand();
	      		command.execute(request, response);
	      		
	      		hsession = request.getSession(true);
				String lookupresultpw = (String)hsession.getAttribute("lookupresult");

				if(lookupresultpw.equals("")) { // 비밀번호 찾기 성공
					viewPage ="lookupfail.jsp";
				}else{ 	// 비밀번호 찾기 실패
					hsession.setAttribute("lookupresult", lookupresultpw);
					viewPage ="lookuppwpop.jsp";
					
				} 
				break;
	    
	      		
	      		
//			--로그인 기능 끝!	 
	      
	      		
	      		
//			--메인 메뉴 리스트 시작!

	      case("/introduction.wd"):  // 입양 페이지
	    	  	viewPage ="introduction.jsp";
	      		break;	      
	      case("/adoptpage.wd"):  // 입양 페이지
	    	  	viewPage ="adopt.wd";
	      		break;	      
	      case("/trainerlist.wd"):  // 훈련사 리스트 페이지
	    	  	command = new TrainerListOpenCommand();
	      		command.execute(request, response);
	      		viewPage ="trainerList.jsp";
	      		break;	      		
	      case("/notice.wd"):  // 게시판 페이지
	    	  viewPage ="noticelist.wd";
	      		break;	      
	     
//				--메인 메뉴 리스트 끝!
	      case("/userUpdateForUser.wd"):  // jy추가5/27
              	command = new UserUpdateCommand();
	      		command.execute(request, response);
	      		viewPage ="home.wd";
	      		break;
	      case("/userOut.wd"):  // jy추가5/27
        		command = new UserDeleteCommand();
        		command.execute(request, response);
        		viewPage ="logout.jsp";
        		break;
				
				
				
//				--게시판 페이지 시작!
	      
	      case("/reviewlist.wd"): // 게시판 후기 페이지
			   command = new ReviewListCommand();
			   command.execute(request, response);
			   viewPage = "reviewlist.jsp";  
			   break;
	       case("/review.wd"):	//후기작성 입력 화면만 띄우기
				viewPage = "review_write.jsp";
				break;
	      case("/review_write.wd"): // 작성 후 다시 후기 페이지로
				command = new ReviewWriteCommand();
				command.execute(request, response);
				viewPage = "reviewlist.wd"; 
				break;
	      case("/reviewdetail.wd"): // review에 detail 데이터 불러오기 (후기 상세 페이지)
				command = new ReviewDetailViewCommand();
				command.execute(request, response);
				viewPage = "review_detailview.jsp";
				break;
		  	case("/reviewmodify.wd"): // 후기 상세 페이지에서 수정 눌러 수정후 목록으로
				command = new ReviewModifyCommand();
				command.execute(request, response);
				viewPage = "reviewlist.wd";
				break;	
		  	case("/review_mdview.wd")://수정페이지 분할
				command = new ReviewMdViewCommand();
				command.execute(request, response);
				viewPage = "review_mdview.jsp";
				break;
			case("/reviewdelete.wd"): // 후기 상세 페이지에서 삭제 눌러 삭제후 목록으로
				command = new ReviewDeleteCommand();
				command.execute(request, response);
				viewPage = "reviewlist.wd";
				break;
		  	
				
		  	case("/noticelist.wd"): // 공지 목록 보기
				   command = new NoticeListCommand();
				   command.execute(request, response);
				   viewPage = "noticelist.jsp";
				   break;
		  	case("/noticedetail.wd"): // 공지 상세 데이터 불러오기
				command = new NoticeDetailViewCommand();
				command.execute(request, response);
				viewPage = "notice_detailview.jsp";
				break;

				
//				--게시판 페이지 끝!
				
//				마이페이지(어드민, 트레이너, 유저)
		     case("/longintypecheck.wd"):  // longintypecheck 페이지 
		      		viewPage ="logintypecheck.jsp";
	      			break;
		      case("/adminpage.wd"):  // admin 페이지 
		    	  	command = new AdminPageOpenCommand();
		      		command.execute(request, response);
	      			viewPage ="adminpage.jsp";
	      			break;
		      case("/trainerpage.wd"):  // trainer 페이지 
		    	  	command = new TrainerPageOpenCommand();
		      		command.execute(request, response);
	      			viewPage ="trainerpage.jsp";
	      			break;
		      case("/userpage.wd"):  // user 페이지 
		    	  	command = new UserPageOpenCommand();
		      		command.execute(request, response);
					viewPage ="userpage.jsp";
					break;				
	      
	      
//			--트레이너 페이지 시작!

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
    			
//    			--트레이너 페이지 끝!
    			
    			
		
//    			-- 어드민_강아지 관리 기능 시작! 			
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
//    			-- 어드민_강아지 관리 기능 끝! 		      		
	      		
//    			-- 어드민_게시판(공지, 리뷰) 관리 기능 시작! 		      		// jy수정5/24
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
	      		
	      		
	   // 관리자 리뷰   		
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
//    			-- 어드민_게시판(공지, 리뷰) 관리 기능 끝! 		      		
      		
	      		
//    			-- 어드민_유저 관리 기능 시작! 		 
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
//    			-- 어드민_유저 관리 기능 끝!      		
	    

	      		
//	      		-- 입양 페이지 시작!
	      case("/adopt.wd") :     // 입양 카테고리 대기 화면으로이동
	      	  command = new BAdoptcommand() ;
	      	  viewPage = "adoptwait.jsp";
	          command.execute(request, response);
	          break;	          
	      case("/adoptwait_02.wd") :   // 입양카테고리 대기 강아지 상세정보
		      command = new BAdoptwait_02command() ;
		      viewPage = "adoptwait_02.jsp";
		      command.execute(request, response);
		      break;
	      case("/adoptapply.wd") :    // 입양 신청시 대기에서 진행으로 바꿔주기
		      command = new BAdoptcommand() ;
		      viewPage = "adoptapply.jsp";
		      command.execute(request, response);
		      break;
	      case("/adoptcomplete.wd") :                    // 입양카테고리 완료 강아지 상세정보
	    	  command = new BAdoptcompletecoammand() ;
		      viewPage = "adoptcomplete.jsp";
		      command.execute(request, response);
		      break;	      
	      case("/adoptcomplete_02.wd") :   // 입양카테고리 완료 강아지 상세정보
		      command = new BAdoptcomplete_02coammand() ;
		      viewPage = "adoptcomplete_02.jsp";
		      command.execute(request, response);
		      break;
	      case("/adoptproceeding.wd") :                 // 입양카테고리 진행 강아지 상세정보
		      command = new BAdoptproceedingcommand() ;
		      viewPage = "adoptproceeding.jsp";
		      command.execute(request, response);
		      break;
	      case("/adoptproceeding_02.wd") :                 // 입양카테고리 진행 강아지 상세정보
	    	  command = new BAdoptproceeding_02command() ;
		      viewPage = "adoptproceeding_02.jsp";
		      command.execute(request, response);
		      
		      break;	
	      case("/adopttraining.wd") :                 // 입양카테고리 훈련 중
	    	  command = new BAdopttrainingcommand() ;
	          viewPage = "adopttraining.jsp";
	         command.execute(request, response);
	      break; 
	      case("/adopttraining_02.wd") :                 // 입양카테고리 훈련 중  강아지 상세정보
		      command = new BAdopttrainingcommand_02() ;
		      viewPage = "adopttraining_02.jsp";
		      command.execute(request, response);
	      break;
	      case("/adoptwaitSearch.wd") :                 // 입양카테고리 가능 검색
	    	  command = new BAdoptSearchcommand();
		      viewPage = "adoptwait.jsp";
		      command.execute(request, response);
	      break;
	      case("/adoptproceedingSearch.wd") :                 // 입양카테고리 진행 검색
	    	  command = new BAdoptSearchcommand();
		      viewPage = "adoptproceeding.jsp";
		      command.execute(request, response);
	      break;
	      case("/adoptcompleteSearch.wd") :                 // 입양카테고리 완료 검색
	    	  command = new BAdoptSearchcommand();
		      viewPage = "adoptcomplete.jsp";
		      command.execute(request, response);
	      break;
	      case("/adopttrainingSearch.wd") :                 // 입양카테고리 훈련 중 검색
	    	  command = new BAdoptSearchcommand();
		      viewPage = "adopttraining.jsp";
		      command.execute(request, response);
	      break;    
	      case("/adoptimginsert.wd") :                 // 이미지 업로드하기
	    	  command = new BAdoptimginsertcommand();
		      viewPage = "adoptimginsert.jsp";
		      command.execute(request, response);
	      break;
//	      		-- 입양 페이지 끝!
		    
	      }
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	      dispatcher.forward(request, response);
	   }

}
