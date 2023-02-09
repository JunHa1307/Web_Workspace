<%
	String pizza = (String) request.getAttribute("pizza");
	String[] topping = (String[]) request.getAttribute("topping");
	String[] side = (String[]) request.getAttribute("side");
	int cost = (int)request.getAttribute("cost");
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 결제 페이지</title>
<style>
	#pizza{color:red}
	#topping{color:green}
	#side{color:blue}
</style>
</head>
<body>
	<h1>주문 내역</h1>
	<h1>
		피자는 <span id="pizza"><%=pizza%></span> 토핑은 <span id="topping">
		 <%if(topping == null){%>
				없고
		 <%}else{
				for (int i = 0; i < topping.length; i++) {
			%> <%=topping[i]%> <%
					if(i != topping.length-1){
						out.print(",");
					}
			 	}
			}%>
		</span> 사이드는<span id="side">
			<%if(side==null){%>
				없고
			<% }else{
				for (int i = 0; i < side.length; i++) {
			%> <%=side[i]%> <% 
					if(i!= side.length-1){
						out.print(",");
					}
			 	}
			 }%>
		</span>주문하셨습니다.
		
		<br><br><br>
		총합 : <u><%=cost%>원</u>
		<br><br><br>
		<span style="color:pink;">즐거운 식사시간 되세요~</span>
	</h1>
</body>
</html>