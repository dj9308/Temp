<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="vo.MyPageVO, vo.MyPageReviewVO, vo.MyPageBasketVO, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 기본 메뉴 -->
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
			if(request.getAttribute("pwmsg")!=null){
		%>		
		<!-- 정보수정시 비밀번호 재확인(비밀번호 재확인 오류시) -->
<form action="/festival/MyPage" method="post" id="confirm1">
<a> 비밀번호 재확인</a><br>
<div>아이디 : <%=vo.getMid()%></div>
<input type="password" name="pw_1" id="pw_1">
<input type="submit" id="submit" value="확인">
<div id="alert" style="color: red;">${pwmsg}</div>
</form>
		<%
			}
			/* 비밀번호 확인 완료시 */
			if(request.getAttribute("enterMsg")!=null){
%>
<div id="up">
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
					<td><img src="" width="120"></td>
					<td><form action="/festival/MyPage" enctype="multipart/form-data" method="post">
    <input type="file" name="imgFile" /><br>
    <input type="submit" value="이미지저장"/><br>
</form>
					</td>
				</tr>
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
	if (request.getAttribute("msg") != null){
%>
	<script>
		alert("${msg}");
	</script>

<%
	}
%>
<!-- 처음 정보수정 누를시 뜨는 비밀번호 재확인 창 -->
		<form action="/festival/MyPage" style="display: none;" method="post" id="confirm">
<a> 비밀번호 재확인</a><br>
<div>아이디 : <%=vo.getMid()%></div>
<input type="password" name="pw_1" id="pw_1">
<input type="submit" id="submit" value="확인">
</form>
		<%
			}
		%>
		
				<!-- 찜 목록 -->
<section id="basket" style="display: none;'">
<fieldset>
			<legend>찜 목록</legend>
	<%
	ArrayList<MyPageBasketVO> hi = (ArrayList<MyPageBasketVO>) request.getAttribute("basket");
	
	if(hi!=null){
			for (MyPageBasketVO data : hi) {
	%>

			<table>
				<tr>
					<td><img src="http://70.12.113.182:8000/festival/resources/images/hihi.jpg" width="150"></td>
					<td> 축제 이름 : <%=data.getName()%><br>
					축제 장소 : <%=data.getPlace()%><br>
					시작 날짜 : <%=data.getOpendate()%><br>
					</td>
				</tr>
			</table>
		</fieldset>

	<% 
			}
	}
		%>	

		</section>
		<!-- 리뷰확인 -->
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
	if(al!=null){
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
	}
	%>
		</table>
		</section>

 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">

$('#updateInfo').click(function() {
	$('#confirm').css('display','block');
	$('#myReview').css('display','none');
	$('#confirm1').css('display','none');
	$('#up').css('display','none');
	$('#basket').css('display','none');
})

$('#showReview').click(function() {
	$('#confirm').css('display','none');
	$('#confirm1').css('display','none');
	$('#myReview').css('display','block');
	$('#up').css('display','none');
	$('#basket').css('display','none');
})

$('#showBasket').click(function() {
	$('#confirm').css('display','none');
	$('#confirm1').css('display','none');
	$('#myReview').css('display','none');
	$('#up').css('display','none');
	$('#basket').css('display','block');
})

</script>



</body>
</html>