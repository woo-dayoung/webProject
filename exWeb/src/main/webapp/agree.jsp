<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="validation.js"></script>
    <title>Agreement</title>
</head>
<body> 
	out.print("<h1>NAVER</h1>");
    <!-- form Object 를 호출한 메소드의 인자를 넘겨주기 -->
    <form method="get" action="join.html">
        1<input type="checkbox" name="choice" value="1"><br>
        2<input type="checkbox" name="choice" value="2"><br>
        3<input type="checkbox" name="choice" value="3"><br>

        <!--<input type="submit">  -->
        <input type="button" value="제출" onclick="checkVal(form)">
        <!--form의 submit 디폴트이벤트가 온클릭의 핸들러로 인하여 기본 이벤트를 무시하고 핸들러가 처리하는 메소드로 대체 처리가 됨-->

    </form>
</body>
</html>