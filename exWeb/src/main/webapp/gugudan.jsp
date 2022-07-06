<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
	<%--2~9단까지 출력 --%>
	<%--타이틀 h1 --%>
	<%--내용 p --%>
	<% 
	out.print("<h1> 랜덤 구구단 </h1>");
	%>
	<%
	Random ran =new Random();
	%>

	<%-- 랜덤 구구단 퀴즈 --%>
	<%-- 문제 10개 form --%>
	<%-- gugudanPro.jsp 페이지에서  --%>
	<%-- 정답지와 함께 성적표 출럭 --%>
	<form action="gugudanPro.jsp">
	<table border="1">
		<thead>
			<tr align="center">
				<td>번호</td>
				<td>문제</td>
				<td>정답</td>
			</tr>
		</thead>
		<tbody>
			<%
			for(int i = 0; i < 10; i++){
			int x = ran.nextInt(8)+2;
			int y = ran.nextInt(10)+1;
			String quiz = String.format("%d x %d ", x, y) ;
			int result = x*y;
			%>
			<tr align="center">
				<td><%=i+1 %></td>
				<td><%=x %> x <%=y %> =</td>
				<td><input type="number" name="answer<%=i+1 %>">
				<input type="hidden" name="quiz<%=i+1 %>" value="<%=quiz%>">
				<input type="hidden" name="result<%=i+1 %>"value="<%=result%>"></td>
			<%
			}
			%>
			</tr>
		</tbody>
	</table>
	<input type="submit">
	</form>
</body>
</html>