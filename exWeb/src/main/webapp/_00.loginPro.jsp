<%@page import="user.UserDTO"%>
<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	UserDAO dao = UserDAO.getInstance();
	UserDTO user= null;
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("utf-8");
	
	String inputId = request.getParameter("inID");
	String inputPw = request.getParameter("inPW");
	
	user =new UserDTO(inputId,inputPw);
	String url ="";
	
	
	if(dao.checklogpw(user.getId(),user.getPassword())){
		url="main.jsp";
		session.setAttribute("log", user.getId());
	}else
		url="_00_index.jsp";
	// 1.리다이렉트 처리
	response.sendRedirect(url);
	
	//2. 이전 페이지에서 가지고온 request& response 객체를 그대로 다음 페이지로 가져간다
	//request.setAttribute("log", user.getId());
	//request.getRequestDispatcher(url).forward(request, response);
	
	//3. 톰캣 세션을 활용한 session에 로그 정보 넣기
	//session.setAttribute("log", user.getId());
%>

</body>
</html>