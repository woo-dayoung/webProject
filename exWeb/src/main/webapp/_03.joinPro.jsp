
<%@page import="user.UserDTO"%>
<%@page import="user.UserDAO"%>
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
	// 요청 받은 데이터에 대한 컨트롤 -> 자바를 통함
	// 자바빈 : 요청된 데이터에 대한 자료 처리방식
	// ㄴ VO: Value Object  read-only
	// ㄴ DTO: 요청 데이터를 -> 트랜잭션 처리하기 위한 -> 임시 객체
	
	// ㄴ DAO(Data Access Object) : 연동된 데이터(중앙)에 대한 요청 내용을 실제 처리 해주는 객체
	// ㄴ Singletone 패턴 적용
	
	UserDAO dao = UserDAO.getInstance();
	UserDTO user= null;
	
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String [] pw = request.getParameterValues("password");
	String name = request.getParameter("name");
	int year =Integer.parseInt(request.getParameter("year"));
	int month =Integer.parseInt(request.getParameter("month"));
	int day =Integer.parseInt(request.getParameter("day"));
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String country = request.getParameter("country"); 
	String mobile = request.getParameter("mobile");
	
	user = new UserDTO(id,pw[0],name,year,month,day,gender,email,country,mobile);
	String url ="";
	if(dao.addUser(user)){ 
		//회원 가입 성공
		//login.jsp로 페이지 이동
		url="_00_index.jsp";
	}else
	{
		//중복으로 인한 회원 가입 실패
		// join.jsp 페이지 이동 
		url="_02.join.jsp";
		
	}
		response.sendRedirect(url);
	%>
	
</body>
</html>