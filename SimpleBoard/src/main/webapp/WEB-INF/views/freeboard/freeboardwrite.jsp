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
<script type="text/javascript" src="../js/service/HuskyEZCreator.js"
	charset="utf-8"></script>
</head>
<body>
	<textarea name="ir1" id="ir1" rows="10" cols="100">에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면 됩니다.</textarea>
<%-- 	<br>
	<p>
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
				<td>내용</td>
				<td><input name="boarddtail" size="100"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;
					<a href="freeboard">목록보기</a></td>
			</tr>
		</table>
	</form> --%>
</body>
<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "ir1",
		sSkinURI : "../SmartEditor2Skin.html",
		fCreator : "createSEditor2"
	});
</script>
</html>