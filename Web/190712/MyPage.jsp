<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="vo.MyPageVO, vo.MyPageReviewVO, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<fieldset>
			<legend>마이페이지</legend>
			<table>
				<tr>
					<td id="updateInfo">정보수정</td>
				</tr>
				
				<tr>
					<td id="showBasket">장바구니</td>
				</tr>
				<tr>
					<td id="showReview">리뷰확인</td>
				</tr>
			</table>
		</fieldset>
			<%
			MyPageVO vo = (MyPageVO)request.getAttribute("info");
			if(vo!=null){
%>
<div id="up" style="display: none;">
<fieldset><form action="/festival/MyPage" method="post">
<input type="hidden" name="action" value="updatepw">
			<legend>비밀번호 수정</legend>
			<table>
			<tr>
					<td>아이디</td>
					<td><%=vo.getMid() %></td>
				</tr>
				<tr>
					<td>기존 비밀번호 입력<br>새 비밀번호 입력<br>새 비밀번호 확인
					</td>
					<td><input type="password" id="oldpw" name="oldpw"><br>
					<input type="password" id="pw1" name="pw1"><br>
						<input type="password" id="pw2" name="pw2"></td>
				</tr>
			</table>
			<input type="submit" value="수정">
			</form>
		</fieldset>
		
		<fieldset><form action="/festival/MyPage" method="post">
		<input type="hidden" name="action" value="updatepm">
			<legend>정보 수정</legend>
			<table>
				<tr>
					<td>휴대전화</td>
					<td><input type="tel" id="phone" name="phone"
					value="<%=vo.getPhone() %>"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" id="eamil" name="email"
		value="<%=vo.getEmail() %>"></td>
				</tr>
			</table>
			<input type="submit" value="수정">
			</form>
		</fieldset>
		</div>
		<%
			}
		%>
		
	<section id="myReview" style="display: none;">
		<table>
			<tr>
				<td>축제명</td>
				<td>내용</td>
				<td>작성일</td>
				<td>평점</td>
			</tr>
	<%
	ArrayList<MyPageReviewVO> al = (ArrayList<MyPageReviewVO>) request.getAttribute("list");
			for (MyPageReviewVO data : al) {
	%>
			<tr>
				<td><%= data.getName() %></td>
				<td><%= data.getRcontent() %></td>
				<td><%= data.getWritedate() %></td>
				<td><%= data.getGrade() %></td>
			</tr>
	<% 
			}
	%>
		</table>
	</section>	
		
		<%
	if (request.getAttribute("msg") != null){
%>
	<script>
		alert("${msg}");
	</script>
	
<%
	}
%>
		
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
$('#updateInfo').live('click', function() {
	$('#up').css('display','block');
	$('#myReview').css('display','none');
})
$('#showReview').live('click', function() {
	$('#up').css('display','none');
	$('#myReview').css('display','block');
})
</script>
</body>
</html>