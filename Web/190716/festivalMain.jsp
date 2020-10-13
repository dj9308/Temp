<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="vo.FestivalVO, java.util.ArrayList, java.util.List" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h2{color: navy;text-shadow: black;}
input {border-radius: 15%;}
footer {position: absolute;bottom: 0;left: 0;
right: 0;color: white;height:50px;background-color: #333333;}
img{width: 400px ;height: 250px;}
</style>
</head>
<body>
<h2>Festas! 환영합니다 :)</h2><hr>

<c:if test="${sessionScope.mid != null}">
	<h2>${sessionScope.mid}님 안녕하세요!</h2>
		<a href="/festival/main">공지사항</a>
		<a href="/festival/logout">로그아웃</a> 
		<a href="/festival/MyPage">마이 페이지</a>
</c:if>

<c:if test="${sessionScope.mid == null}">
	<a href="/festival/notice">공지사항</a>
	<a href="/festival/loginmain">로그인</a>
	<a href="/festival/memberForm">회원가입</a>
</c:if>

<output></output>
<form method="get" action="/festival/list">
<input type="hidden" name="action" value="search">
<input type="hidden" name="pageNo" value="1">
<section>
	<select name="city">
		<option value="서울특별시">서울특별시</option>
		<option value="경기도">경기도</option>
	</select>
	<select name="district">
		<option value="강남구">강남구</option><option value="강동구">강동구</option>
		<option value="강북구">강북구</option><option value="강서구">강서구</option>
		<option value="관악구">관악구</option><option value="광진구">광진구</option>									
		<option value="구로구">구로구</option><option value="금천구">금천구</option>									
		<option value="노원구">노원구</option><option value="도봉구">도봉구</option>									
		<option value="동대문구">동대문구</option><option value="동작구">동작구</option>	
		<option value="마포구">마포구</option><option value="서대문구">서대문구</option>		
		<option value="서초구">서초구</option><option value="성동구">성동구</option>
		<option value="성북구">성북구</option><option value="송파구">송파구</option>
		<option value="양천구">양천구</option><option value="영등포구">영등포구</option>
		<option value="용산구">용산구</option><option value="은평구">은평구</option>
		<option value="종로구">종로구</option><option value="중구">중구</option>
		<option value="중랑구">중랑구</option>				  	
	</select>
	<select name="month">
		<option value="01">1월</option><option value="02">2월</option>
		<option value="03">3월</option><option value="04">4월</option>
		<option value="05">5월</option><option value="06">6월</option>
		<option value="07">7월</option><option value="08">8월</option>
		<option value="09">9월</option><option value="10">10월</option>
		<option value="11">11월</option><option value="12">12월</option>
	</select>
	<select name="type">
		<option value="문화예술">문화예술</option><option value="주민화합">주민화합</option>
		<option value="전통역사">전통역사</option><option value="지역특산물">지역특산물</option>
		<option value="생태자연">생태자연</option><option value="기타">기타</option>
	</select>
	<input type="submit" value="검색하기">
</section>
</form>
<hr>
<h2>이달의 축제 및 고평점 축제 ↓↓↓</h2>
<section>
<a href="select?fid=001"><img name="a1"src="resources/images/a1.png"></a>
<a href="select?fid=002"><img name="a2"src="resources/images/a2.jpg"></a>
<a href="select?fid=003"><img name="a3"src="resources/images/a3.jpg"></a>
<br>
<%-- 	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>내용들</td>
		</tr>
		<tr>
			<%//이달의 축제 3개 
			List<FestivalVO> list = (List<FestivalVO>) request.getAttribute("list");
				if (list == null) {
					for (FestivalVO vo : list) {
			%>
			<td><%= vo.getFid()%></td>
			<td onclick="displayUpdateForm('<%=vo.getFid()%>')"><%=vo.getName()%></td>
			<td onclick="displaywriter('<%=vo.getFid()%>')"><%=vo.getName()%></td>
		</tr>
		<%
			}
		}
		%>
	</table> --%>
<c:if test='${!empty resultlist }'>
	<table >
		<c:forEach var="vo" items="${resultlist.list }">
			<tr>
				<td><img src="resources/images/${vo.fid }/01.png" height='100'></td>
				<td>
				<h2>${vo.name }</h2>
				${vo.place }<br>
				${vo.opendate }~${vo.closedate }
				</td>
			</tr>
		</c:forEach>
		<c:if test="${resultlist.hasFestivals()}">
		<tr>
		<td>
			<c:if test="${resultlist.startPage > 5}">
				<a href="list?pageNo=${resultlist.startPage - 5}&action=paging">[이전]</a>
			</c:if>
			<c:forEach var="pNo" begin="${resultlist.startPage}" 
						end="${resultlist.endPage}">
				<a href="list?pageNo=${pNo}&action=paging">[${pNo}]</a>
			</c:forEach>
			<c:if test="${resultlist.endPage < resultlist.totalPages}">
				<a href="list?pageNo=${resultlist.startPage + 5}&action=paging">[다음]</a>
			</c:if>
		</td>
		</tr>
		</c:if>		
	</table>
</c:if>		
	</section>
<footer>
<i>Except where otherwise noted, 
content on this site is licensed under a Creative Commons Attribution 4.0
International license.
</i></footer>
</section>
</body>
</html>