<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
댓글 목록<br>
	<c:forEach var="dto" items="${comment}">
	<tr>
	<td>${dto.commentuserid}</td>
	<td>${dto.commentcontent}</td>
	<td>${dto.commentdate}</td>
	</tr><br>
	</c:forEach>
<hr>
<form action="/comment/write" method="post">
댓글 : <textarea rows="10" cols="20" name="commentcontent"></textarea>
<%-- <input type="hidden" value="${comment.boardnumber}" name="boardnumber"> --%>
<input type="submit" value="작성">
</form>
<hr>
</body>
</html>