<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
<script type="text/javascript" src="../se2/js/service/HuskyEZCreator.js"
	charset="utf-8"></script>
</head>
<body>
	<form action="freeboardwrite" method="post">
		<table>
			<tr>
				<td>작성자</td>
				<td><input name="userid" size="100" value="${id}" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input name="boardtitle" size="100"></td>
			</tr>
			<tr>
		</table>
		<textarea name="ir1" id="ir1" rows="10" cols="100">Test</textarea>
		<input type="submit" value="작성">
	</form>
	<a href="freeboard">목록보기</a>
</body>
<script>
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "ir1",
		sSkinURI : "../se2/SmartEditor2Skin.html",
		fCreator : "createSEditor2"
	});
</script>
</html>