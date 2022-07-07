<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	/*
		// post 메소드로 전달된 파라미터 값 확인
		// ㄴ 캐릭터셋 인코딩을 반드시 맞춰주어야 한다.
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		
		id
		password[]
		name
		year
		month
		day
		gender
		email
		country
		mobile
		
		String id = request.getParameter("id");
		String [] pw = request.getParameterValues("password");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String mobile = request.getParameter("mobile");
		out.print(id);
		out.print(pw[0]);
		out.print(pw[1]);
		out.print(name);
		out.print(year);
		out.print(month);
		out.print(day);
		out.print(gender);
		out.print(email);
		out.print(country);
		out.print(mobile);
		*/
	%>
	<%
	String log = (String)session.getAttribute("log");
	System.out.println(log);
	if(log == null){
		response.sendRedirect("_00_index.jsp");
	}
	else{%>
		<h1><%=log %>님 환영합니다</h1>
		<button onclick="location.href='_00._logoutPro.jsp'">로그아웃</button>
		<% 
	}
		%>
		<form method="post" action="remove.jsp">
		<input type="password" class="reqlog" name="inPW" placeholder="PASSWORD">
		<input type="hidden" value="<%=log %>" name="log">
		<input type="submit"  value="탈퇴">
		<input type="button" value="게시판" onclick="location.href='_05.board.jsp'">
		</form>
		
</body>
</html>