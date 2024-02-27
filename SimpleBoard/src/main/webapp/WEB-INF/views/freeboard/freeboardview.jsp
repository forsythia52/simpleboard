<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 내용</title>
</head>
<body>
	내용보기
	<br>
	<hr>
	작성자 : ${board.userid}
	<br> 제목 : ${board.boardtitle}
	<br> 내용 : ${board.boarddtail}
	<br>
	<hr>
	<br>
	<p>
	<div><form action="freeboardupdate" method="get">
		<input type="submit" value="수정"> <input type="hidden"
			name="boardnumber" id="freeboardupdateboardnumber">
	</form>
	<form action="freeboarddelete" method="post">
		<input type="submit" value="삭제"> <input type="hidden"
			name="boardnumber" id="freeboarddeleteboardnumber">
	</form>
	</div>
	
	<a href="freeboard">목록보기</a>
	<hr>
	댓글 목록
	<br>
	<c:forEach var="dto" items="${comment}">
		<tr>
			<td>${dto.commentuserid}</td>
			<td>${dto.commentcontent}</td>
			<td>${dto.commentdate}</td>
			<td>${dto.commentnumber}</td>
		</tr>
		<form action="/comment/delete" method="post">
			<input type="hidden" name="commentuserid" value="${dto.commentuserid}">
			<input type="hidden" name="commentnumber" value="${dto.commentnumber}">
			<input type="submit" value="삭제">
		</form>
		<br>
	</c:forEach>
	<hr>
	<form action="/comment/write" method="post">
		댓글 :
		<textarea rows="10" cols="20" name="commentcontent"></textarea>
		<input type="submit" value="작성"> <input type="hidden"
			name="boardnumber" id="commemtboardnumber">
	</form>

	<hr>
	<script>
		// 게시판 번호 가져오기
		const urlParams = new URL(location.href).searchParams;
		const number = urlParams.get('number');
		
		// 게시글 수정
		document.getElementById("freeboardupdateboardnumber").value = number;
		
		// 게시글 삭제
		document.getElementById("freeboarddeleteboardnumber").value = number;
		
		// 댓글 작성
		document.getElementById("commemtboardnumber").value = number;
	</script>
</body>
</html>