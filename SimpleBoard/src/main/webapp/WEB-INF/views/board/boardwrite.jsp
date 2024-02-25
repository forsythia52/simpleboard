<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style type="text/css">
table {
	width: 500;
	border: 1;
}
</style>
</head>
<body>
	<br>
	<p>
	<form action="write" method="post">
	<table>
			<tr>
				<td>작성자</td>
				<td><input name="usernid" size="100" value="${id}" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input name="boardtitle" size="100"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input name="boarddtail" size="100"></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="입력">&nbsp;&nbsp; <a href="freeboard">목록보기</a> </td>
			</tr>
	</table>
	</form>
</body>
</html>