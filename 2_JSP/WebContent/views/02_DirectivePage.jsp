<%@ page import="java.util.ArrayList, java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> <%-- errorPage="error500.jsp" --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어</title>
</head>
<body>
	<h1>page 지시어</h1>
	
	<%
		// ArrayList사용 
		// 지시어 부분에 import="java.util.ArrayList" 추가 시 에러는 없어진다.
		ArrayList<String> list = new ArrayList<>();
		list.add("Servlet");
		list.add("JSP");
		
		Date today = new Date();
	%>
	
	<p>
		리스트의 길이 : <%= list.size() %><br>
		0번 인덱스의 값 : <%= list.get(0) %><br>
		1번 인덱스의 값 : <%= list.get(1) %><br>
		현재 날짜는 ? : <%= today %>
	</p>
	
	<%= list.get(10) %>
</body>
</html>