<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<form action="freeboardupdate" method="post">
제목: <input value="${board.boardtitle}" name="boardtitle"><br>
내용: <input value="${board.boarddtail}" name="boarddtail"><br>
<input type="hidden" id="boardnumber" name="boardnumber">
<input type="submit" value="수정">
</form>
<script>
const urlParams = new URL(location.href).searchParams;

const number = urlParams.get('boardnumber');

// 게시글 수정
document.getElementById("boardnumber").value = number;
</script>
</body>
</html>