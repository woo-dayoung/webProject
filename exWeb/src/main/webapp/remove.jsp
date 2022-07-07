
<%@page import="user.UserDTO"%>
<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
UserDAO dao = UserDAO.getInstance();
UserDTO user= null;
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("utf-8");

String logId = request.getParameter("log");
String inputPw = request.getParameter("inPW");
user =new UserDTO(logId,inputPw);
String url ="";

if(dao.deluser(user.getId(),user.getPw())){
	url="_00_index.jsp";
}
else
	url="_04.main.jsp";
response.sendRedirect(url);
%>

</body>
</html>