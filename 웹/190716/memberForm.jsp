<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<style>
h2{ color: black; text-shadow: black; }
input { border-radius: 15%; }
form {size: 300px;}
</style>
</head>
<body>
	<section id="signupForm">
		<form method="POST" action="/festival/memberForm" >
			
			<!-- 0 -->
			아이디<br>
			<input id="userId" type="text" name="mid" required><br>
			<div id="idError"></div><br>
			
			<!-- 1 -->
			비밀번호<br>
			<input id="pw" type="password" name="pw" required><br><br>
			
			<!-- 2 -->
			비밀번호 재확인<br>
			<input id="pwcheck" type="password" name="pwcheck" 
						onkeyup="checkPwd()" required><br><br>
			<div id="checkPwd"></div>
			 
			이메일<br>
			<input type="text" name="email" required><br><br>
			
			핸드폰 번호 입력<br>
			<input id=phone name=phone type=tel 
                       placeholder="00*-000*-0000" 
                       pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}"><br><br>		
			<input id="submit" type="submit" value="가입하기">
		</form>
	</section>

<script>
function checkPwd(){
  var pw1 =	document.getElementById('pw').value
  var pw2 = document.getElementById('pwcheck').value
  if(pw1!=pw2){
   document.getElementById('checkPwd').style.color = "red";
   document.getElementById('checkPwd').innerHTML = "동일한 암호를 입력하세요."; 
  }else{
   document.getElementById('checkPwd').style.color = "blue";
   document.getElementById('checkPwd').innerHTML = "암호가 확인 되었습니다."; 
   
  }
  
 }
</script>
	
	<script>
		$(document).ready(function(){
			$("#userId").blur(function(){
				var mid = $("#userId").val();
				$.ajax({
					url : '/festival/validateForm?mid=' + mid,
					type : 'get',
					success : function(data){
						if (data == 1){ // id 중복됨
							$('#idError').text("이미 사용중인 아이디입니다. =ㅅ=").css("color", "red");
							$("#submit").attr("disabled", true);
						}
						else {
							$('#idError').text("사용 가능한 아이디입니다. :) ").css("color", "blue");
							$("#submit").attr("disabled", false);					
						}
					},					
					error : function(){ console.log("실패"); }
				});
			});
		})
	</script>
</body>
</html>