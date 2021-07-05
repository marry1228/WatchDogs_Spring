<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>회원가입 화면</title>
        <link rel="stylesheet" href="style.css">
    </head>
    
    <body>
        <div class="wrap">
        
            <div class="form-wrap">

                <div class="icon">
                    <a href="home.jsp"><img src="images/logo.png" width="150px" height="100px" alt="WatchDogs"></a>
                </div>

                <form id="left" action="signupfunction.wd" class="input-group" method="post">
                    <input type="text" name="userid" class="input-field" placeholder="아이디" required>
                    <input type="password" name="userpw" class="input-field" placeholder="비밀번호" required>
                    <input type="text" name="usertel" class="input-field" placeholder="전화번호" required>
                    <input type="email" name="useremail" class="input-field" placeholder="이메일" required>
                    <input type="text" name="username" class="input-field" placeholder="이름" required>
                    <button class="submit" >등록하기</button>    
                    <div class="lookup">   
                    <a href="lookupidpw.wd" >아이디 / 비밀번호 찾기</a>          
                	</div>  
                </form>
                                                
            </div>
            
            
       		<div class="Foot">     
            <hr class="hide">
				<a href=http://abc class="link_kcorp" target="_blank"
					data-tiara-action-name="watchdogs_소개">&copy; WatchDogs Corp.</a>
				|
				<a href=http://abc class="link_custom" target="_blank"
					data-tiara-action-name="고객센터">고객센터</a>
			</div>            
            
        </div>	

    </body>
</html> 

