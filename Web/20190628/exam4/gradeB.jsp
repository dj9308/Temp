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
<h2><%= name %>님은 B등급입니다. 양호한 성적이네요</h2>
</body>
</html>