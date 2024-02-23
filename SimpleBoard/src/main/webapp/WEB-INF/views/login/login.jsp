<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h3>로그인</h3>
<form action="/login" method="post">
아이디 : <input name="id" ><br>
비밀번호 : <input type="password" name="pw">
<input type="submit" value="전송">
</form>
<a href="/register">회원가입</a>
</body>
</html>