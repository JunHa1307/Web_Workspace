<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 지시어</title>
</head>
<body>
	<h1>include 지시어</h1>
	
	<h2>01_ScriptingElement.jsp파일 include</h2>
	<%@ include file="01_ScriptingElement.jsp" %>
	
	포함한 jsp상에 존재하는 변수를 가져다 쓸 수 있음 <br>
	1부터 100까지의 총 합계 : <%= sum %>
	
	<h2>오늘 날짜</h2>
	<%@ include file="datePrint.jsp" %>
</body>
</html>