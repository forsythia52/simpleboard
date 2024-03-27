<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>
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
<!-- CSS -->
<link href="css/boardcss.css" rel="stylesheet" type="text/css">
<body>
	<!-- header -->
	<%@include file="../bootstrap/header.jsp"%>
	<!-- sidebar -->
	<%@include file="../bootstrap/sidebar.jsp"%>
	<div class="board">
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
			</select> <input class="form-control rounded" name="search" aria-label="Search" aria-describedby="search-addon">
			<input type="submit" value="검색" class="btn btn-outline-primary">
		</form>

		<!-- 페이징 -->
		<nav aria-label="Page navigation example" style="margin-top: 30px;">
			<ul class="pagination justify-content-center">
				<li class="page-item"><c:if
						test="${startPageNumber > pageSelect }">
						<a href="freeboard?page=${startPageNumber-1 }" class="page-link">이전</a>
					</c:if></li>
				<c:forEach begin="${startPageNumber }" end="${endPageNumber}"
					var="i">
					<li class="page-item"><a
						href="freeboard?page=${i}" class="page-link">${i}</a></li>
				</c:forEach>
				<c:if test="${endPageNumber < totalPages }">
					<a href="freeboard?page=${endPageNumber+1}" class="page-link">다음</a>
				</c:if>
			</ul>
		</nav>
	</div>
	<a href="/boardwrite">글 작성</a>
	<!-- footer -->
	<%@include file="../bootstrap/footer.jsp"%>
</body>
</html>