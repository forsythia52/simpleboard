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
	<!-- 페이징 -->
	선택 할 수 있는 페이지 수 : ${pageSelect }
	<br> 페이징 시작 번호 : ${startPageNumber }
	<br> 페이징 끝 번호 : ${endPageNumber }
	<br> 총 페이지 수 : ${totalPage }
	<br>

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