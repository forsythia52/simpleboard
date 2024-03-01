<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
</head>
<body>
	<table>
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성시간</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="dto" items="${result}">
			<tr>
				<td>${dto.boardnumber}</td>
				<td>${dto.userid}</td>
				<td><a href="freeboardview?number=${dto.boardnumber}">${dto.boardtitle}
						[${dto.commentcount}]</a></td>
				<td>${dto.boardwritedate}</td>
				<td>${dto.boardviews}</td>
			</tr>
		</c:forEach>
</body>
</html>