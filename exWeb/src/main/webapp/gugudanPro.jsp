<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
	for(int i=0;i<10;i++){
		int answer = Integer.parseInt(request.getParameter("answer" + (i+1)));
		int result = Integer.parseInt(request.getParameter("result" + (i+1)));
		String quiz = request.getParameter("quiz" + (i+1));
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr align="center">
				<td>번호</td>
				<td>문제</td>
				<td>정답</td>
				<td>결과</td>
				<td>OX</td>
			</tr>
		</thead>
		<tbody>
			<%
			int score =0;
			for(int i=0;i<10;i++){
				int answer = Integer.parseInt(request.getParameter("answer" + (i+1)));
				int result = Integer.parseInt(request.getParameter("result" + (i+1)));
				String quiz = request.getParameter("quiz" + (i+1)); 
				
				if(answer == result){
					score+=10;
				}
				%>
				<tr>
				<td><%=i+1 %></td>
				<td><%=quiz %></td>
				<td><%=result %></td>
				<td><%=answer %></td>
				<td><%=answer == result ? "O" : "X" %></td>
			</tr>
			<%}
			%>
			</tr>
		</tbody>
	</table>
	<h1>당신의 점수는 <%=score %>점입니다</h1>
	

</body>
</html>