<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="form.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <title>AGREEMENT</title>
</head>
<body>
    <h1>GREEN</h1>
    <form action="_02.join.jsp">
        <div class="contents">
              <input id="checkAll" type="checkbox" name="checkAll" value="checkAll">
              이용약관, 개인정보 수집 및 이용, 위치정보 이용약관(선택),프로모션 정보 수신(선택)에 모두 동의합니다.<br><br>

            <input type="checkbox" name="agree" value="1">이용약관 동의(필수)<br>
            <p>
               이용약관 동의
             
            </p>

            <input type="checkbox" name="agree" value="2">개인정보 수집 및 이용 동의(필수)<br>
            <p>
                개인정보 수집 동의
            </p>

            <input type="checkbox" name="agree" value="3">위치정보 이용 약관(선택)<br>
            <p>
                위치정보 이용약관 동의
            </p>

            <input type="checkbox" name="agree" value="4">프로모션 정보 동의(선택)<br>
            <p>
                프로모션 정보 동의
            </p>
        </div>

        <div class="buttons">
            <div class="warning">
                <span>이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.</span><br><br>
            </div>
            <input type="button" onclick="location.href='_00_index.jsp'" value="취소">
            <input type="button" onclick="checkVal(form)" value="확인">
        </div>
    </form>
    <script src="validation.js"></script>
</body>
</html>