<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>로그인</title>
        <link rel="stylesheet" href="style.css">
    </head>

    
    <body>
        <div class="wrap">
            <div class="form-wrap">

                <div class="icon">
                   <a href="home.jsp"> <img src="images/logo.png" width="150px" height="100px" alt="WatchDogs"></a>
                </div>
                <form id="left" action="logincheck.wd" class="input-group2" method="post">
                    <input type="text" name="userid" class="input-field" placeholder="아이디" required>
                    <input type="password" name="userpw" class="input-field" placeholder="비밀번호" required>
                    <input type="checkbox" class="checkbox"><span>아이디 기억하기</span>
                    <button class="submit">로그인</button>
                
                </form>
          
            </div>         
            
            <br><br>
            

			<div class="Foot">
				<hr class="hide">
				<a href=http://abc class="link_kcorp" target="_blank"
					data-tiara-action-name="watchdogs_소개">&copy; WatchDogs Corp.</a>
				|
				<a href=http://abc class="link_custom" target="_blank"
					data-tiara-action-name="고객센터">고객센터</a>
			</div>
        </div>
       
       <script type="text/javascript">
       		alert('아이디 또는 비밀번호가 올바르지 않습니다.');
       </script>
    </body>
</html> 

