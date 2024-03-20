<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!-- 부트스트랩 CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!-- 부트스트랩 JS -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>
	<h3>자유 게시판</h3>
	${userInfo.usernickname}님 로그인중
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
				<td><a href="freeboardview?number=${dto.boardnumber}">${dto.boardtitle}
						[${dto.commentcount}]</a></td>
				<td>${dto.boardwritedate}</td>
				<td>${dto.boardviews}</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 검색 -->
	<form action="search">
		<select name="order">
			<option value="titleanddetail">제목 + 내용</option>
			<option value="writer">작성자</option>
		</select> <input name="search"> <input type="submit" value="검색">
	</form>

	<!-- 페이징 -->
	<div class="paging">
		<div id="page">
			<c:if test="${startPageNumber > pageSelect }">
				<a href="freeboard?page=${startPageNumber-1 }" class="page prv">이전</a>
			</c:if>
			<c:forEach begin="${startPageNumber }" end="${endPageNumber}" var="i">
				<a href="freeboard?page=${i}">${i}</a>
			</c:forEach>
			<c:if test="${endPageNumber < totalPages }">
				<a href="freeboard?page=${endPageNumber+1}" class="page next">다음</a>
			</c:if>
		</div>
	</div>
	<br>
	<p>
		<a href="/boardwrite">글 작성</a>
	</p>
	<p>
		<a href="/logout">로그아웃</a>
	</p>
</body>
</html>