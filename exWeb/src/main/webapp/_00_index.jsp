<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="form.css">
<title>Insert title here</title>
</head>
<body>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("utf-8");

UserDAO dao = UserDAO.getInstance();

if(dao.getConnection()!=null){ 
	System.out.println("데이터베이스 연동 완료");
}
else{
	System.out.println("데이터베이스 연동 실패");
}
%>

	<form method="post" action="_00.loginPro.jsp">
	<h1>log</h1>
		<div>
			<input type="text" class="reqlog" name="inID" placeholder="ID">
			<input type="password" class="reqlog" name="inPW"
				placeholder="PASSWORD">
		</div>
		<div>
			<input type="submit" value="로그인"> 
			<input type="button" value="회원가입" onclick="location.href='_01.agree.jsp'">
		</div>
	</form>

</body>
</html>