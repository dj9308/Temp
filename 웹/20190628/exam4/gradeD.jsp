<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String name = request.getParameter("name"); 
%>
<h2><%= name %>님은 D등급입니다.... 알아서 살길을 찾으세요 </h2>
</body>
</html>