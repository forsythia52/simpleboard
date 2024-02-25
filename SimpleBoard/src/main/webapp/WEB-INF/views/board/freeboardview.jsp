<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 내용</title>
</head>
<body>
내용보기 <br>
<hr>
작성자 : ${board.userid}<br>
제목 : ${board.boardtitle}<br>
내용 : ${board.boarddtail}<br>
<hr>
<br><p>
<a href="freeboard">목록보기</a>
<hr>
댓글 : <textarea rows="10" cols="20"></textarea>
<form action="/comment/write" method="post">
<input type="submit" value="작성">
</form>
<hr>
</body>
</html>