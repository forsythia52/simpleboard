<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>
<style type="text/css">
table {
	width: 100%;
	border: 1px solid #000000;
}
th, td {
	border: 1px solid #000000;
	padding-left: 10px;
	padding-right: 10px;
	text-align: center;
}
</style>
</head>
<body>
<h3>자유 게시판</h3>
<table>
	<tr>
	<td>번호</td>
	<td>작성자</td>
	<td>제목</td>
	<td>작성시간</td>
	<td>조회수</td>
	</tr>
	<c:forEach var="dto" items="${board}">
	<tr>
	<td>${dto.boardnumber}</td>
	<td>${dto.userid}</td>
	<td><a href="view?number=${dto.boardnumber}">${dto.boardtitle}</a></td>
	<td>${dto.boardwritedate}</td>
	<td>${dto.boardviews}</td>
	</tr>
	</c:forEach>
</table>
<p><a href="/boardwrite">글 작성</a></p>
<p><a href="/logout">로그아웃</a></p>
</body>
</html>