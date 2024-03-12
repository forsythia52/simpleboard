<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<!-- ckediter -->
<script
	src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
<!-- 이미지 업로드 어댑터 -->
<script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
<!-- css -->
<link href="../ckediter/setting.css" rel="stylesheet" type="text/css">
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
		</table>
		<textarea name="content" id="editor"></textarea>
		<p>
			<input type="submit" value="전송">
		</p>
	</form>
	<a href="freeboard">목록보기</a>
</body>
<script>
	// 에디터 구현
	ClassicEditor.create(document.querySelector('#editor'), {
		language : "ko",
		removePlugins : [ 'Heading' ]
	});
	// 이미지 업로드
</script>
</html>