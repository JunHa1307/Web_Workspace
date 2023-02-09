<%@ page import="java.util.Date, java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문 페이지</title>
<style>
#date {
	color: pink
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<%
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		String today = sdf.format(date);
	%>
	<h1>
		오늘은 <span id="date"><%=today%></span> 입니다
	</h1>

	<h1>피자 아카데미</h1>
		<table>
			<tr>
				<th>종류</th>
				<th colspan="3">이름</th>
				<th>가격</th>
				<th rowspan="12">&nbsp;</th>
				<th>종류</th>
				<th colspan="3">이름</th>
				<th>가격</th>
			</tr>
			<tr>
				<td rowspan="5">피자</td>
				<td colspan="3">치즈피자</td>
				<td id="Pcost">5000</td>
				<td rowspan="11">사이드</td>
				<td colspan="3">오븐구이 통닭</td>
				<td id="Scost">9000</td>
			</tr>
			<tr>
				<td colspan="3">콤비네이션피자</td>
				<td id="Pcost">6000</td>
				<td colspan="3">치킨스틱&윙</td>
				<td id="Scost">4900</td>
			</tr>
			<tr>
				<td colspan="3">포테이토피자</td>
				<td id="Pcost">7000</td>
				<td colspan="3">치즈오븐스파게티</td>
				<td id="Scost">4000</td>
			</tr>
			<tr>
				<td colspan="3">고구마피자</td>
				<td id="Pcost">7000</td>
				<td colspan="3">새우탕&웨지감자</td>
				<td id="Sost">3500</td>
			</tr>
			<tr>
				<td colspan="3">불고기피자</td>
				<td id="Pcost">8000</td>
				<td colspan="3">갈릭포테이토</td>
				<td id="Scost">3000</td>
			</tr>
			<tr>
				<td rowspan="6">토핑</td>
				<td colspan="3">고구마무스</td>
				<td id="Tcost">1000</td>
				<td colspan="3">콜라</td>
				<td id="Scost">1500</td>
			</tr>
			<tr>
				<td colspan="3">콘크림무스</td>
				<td id="Tcost">1500</td>
				<td colspan="3">사이다</td>
				<td id="Scost">1500</td>
			</tr>
			<tr>
				<td colspan="3">파인애플토핑</td>
				<td id="Tcost">2000</td>
				<td colspan="3">갈릭소스</td>
				<td id="Scost">500</td>
			</tr>
			<tr>
				<td colspan="3">치즈토핑</td>
				<td id="Tcost">2000</td>
				<td colspan="3">피클</td>
				<td id="Scost">300</td>
			</tr>
			<tr>
				<td colspan="3">치즈크러스트</td>
				<td id="Tcost">2000</td>
				<td colspan="3">핫소스</td>
				<td id="Scost">100</td>
			</tr>
			<tr>
				<td colspan="3">치즈바이트</td>
				<td id="Tcost">3000</td>
				<td colspan="3">파마산 치즈가루</td>
				<td id="Scost">100</td>
			</tr>
		</table>
		<br><br>
		<form action="/jsp/RequestPizzaOrder" method="post">
		피자 : 
		<select name="pizza">
			<option>치즈피자</option>
			<option>콤비네이션피자</option>
			<option>포테이토피자</option>
			<option id="pizza" value="고구마피자">고구마피자</option>
			<option id="pizza" value="불고기피자">불고기피자</option>
		</select> <br> 
		토핑 : 
		<input type="checkbox" name="topping" value="고구마무스">고구마무스
		<input type="checkbox" name="topping" value="콘크림무스">콘크림무스 
		<input type="checkbox" name="topping" value="파인애플토핑">파인애플토핑 
		<input type="checkbox" name="topping" value="치즈토핑">치즈토핑 
		<input type="checkbox" name="topping" value="치즈크러스트">치즈크러스트 
		<input type="checkbox" name="topping" value="치즈바이트">치즈바이트 <br>
		사이드 : 
		<input type="checkbox" name="side" value="오븐구이 통닭">오븐구이 통닭 
		<input type="checkbox" name="side" value="치킨스틱&윙">치킨스틱&윙 
		<input type="checkbox" name="side" value="치즈오븐스파게티">치즈오븐스파게티 
		<input type="checkbox" name="side" value="새우탕&웨지감자">새우탕&웨지감자 
		<input type="checkbox" name="side" value="갈릭포테이토">갈릭포테이토 
		<input type="checkbox" name="side" value="콜라">콜라 
		<input type="checkbox" name="side" value="사이다">사이다 
		<input type="checkbox" name="side" value="갈릭소스">갈릭소스 
		<input type="checkbox" name="side" value="피클">피클 
		<input type="checkbox" name="side" value="핫소스">핫소스 
		<input type="checkbox" name="side" value="파마산 치즈가루">파마산 치즈가루 
		<br>
		<input type="submit" value="확인">
	</form>
</body>
</html>