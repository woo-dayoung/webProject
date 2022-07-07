<%@page import="java.util.Random"%>
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
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

BoardDAO dao = BoardDAO.getInstance();
BoardDTO list = null;
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

Random ran=new Random();

int no = 0;
int code = ran.nextInt()+1000;
String title=request.getParameter("title");
String contents=request.getParameter("contents");

list=new BoardDTO(no,code,title,contents);
String url ="";

if()





%>

</body>
</html>