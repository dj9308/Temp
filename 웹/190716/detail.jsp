<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.detailVO, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<detailVO> hi = (ArrayList<detailVO>) request.getAttribute("list");
		if (hi != null) {
			for (detailVO data : hi) {
	%>
	<h1><%=data.getName()%></h1>
	<br>
	<br>
	<table>
		<tr>
			<img src="" width="320">
		</tr>
		<tr>
		<%
		
		%>
			<td><img src="" width="80"></td>
		</tr>
	</table>
	<div>축제 정보</div>
	<div><%=data.getPlace()%></div>
	<div><%=data.getType()%></div>
	<div><%=data.getHostinfo()%></div>
	<div><%=data.getFcontent()%></div>

	<%
		}
		}
	%>
</body>
</html>