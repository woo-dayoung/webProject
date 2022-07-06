<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP주석 --%>
	<%
		//JSP : Java Server Page
		//html 문서 안에 java문법을 작성할 수 있다
		System.out.println("여기에 자바 문법을 작성할수있다."); //콘솔 출력
		out.print("<h1>안녕 지구</h1>"); //크롬 출력
		
		String name = "김지연";
	%>

	<!-- html 문법안에서 jsp 태그로 java 변수 가져오기 -->

	<%
	if(name.equals("김지연")){%>
	<h1><%=name%>님 환영합니다.
	</h1>
	<% 
	}
	%>

</body>
</html>