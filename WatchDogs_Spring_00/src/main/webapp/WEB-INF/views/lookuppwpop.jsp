<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%
    	String lookupresult = (String)session.getAttribute("lookupresult");
    %>   
<!DOCTYPE html>
<html>
    <head>
        <title> 아이디 찾기 </title>
        <link rel="stylesheet" href="style.css">           
    </head>

    <body>
        <div class="wrap">
            <div class="form-wrap">
            
<!--            	 버튼 구역 -->
                <div class="button-wrap">
                    <div id="btn"></div>
                    <button type="button" class="togglebtn" onclick="lookupid()">id 찾기</button>
                    <button type="button" class="togglebtn" onclick="lookuppw()">pw 찾기</button>
                </div>
                
<!--                 아이콘 구역 -->
                <div class="icon">
                    <a href="home.jsp"> <img src="images/logo.png" width="150px" height="100px" alt="WatchDogs"></a>
                </div>
                <br>
                
 <!--                id찾기 폼-->
                <form id="left" action="lookupidfunction.wd" class="input-group2" method="post">
                    <input type="text" name="username" class="input-field" placeholder="이름" required>
                    <input type="email" name="useremail" class="input-field" placeholder="이메일" required>  

                    <button class="submit">아이디 찾기</button>  
                </form>               
                
 <!--                pw찾기 폼-->
                <form id="right" class="input-group2" method="post">                
                	<input type="text" id="userid" class="input-field" placeholder="아이디" required>  
                	<br><br>
                	<select name="language" >
					    <option value="none">=== 선택 ===</option>
					    <option value="korean" selected>한국어</option>
					    <option value="english">영어</option>
					    <option value="chinese">중국어</option>
					    <option value="spanish">스페인어</option>
					</select>              	 
                	<input type="text" id="userpwquiz" class="input-field" placeholder="질문의 대답을 입력해 주세요." required>                	 
                    <button class="submit">다음</button>  
                   
                </form>
                
                
            </div>            
        </div>
        
         <script type="text/javascript">
	
	            var x = document.getElementById("left");   
	            var y = document.getElementById("right");
	            var z = document.getElementById("btn");
	        
	            function lookupid(){
	                x.style.left = "50px";
	                y.style.left = "450px";
	                z.style.left = "0";
	            }
	
	            function lookuppw(){
	                x.style.left = "-400px";
	                y.style.left = "50px";
	                z.style.left = "110px";
	            }
	            
	            window.onload(alert('비밀번호는 <%=lookupresult%> 입니다.'));
	    </script>
    </body>
</html> 

