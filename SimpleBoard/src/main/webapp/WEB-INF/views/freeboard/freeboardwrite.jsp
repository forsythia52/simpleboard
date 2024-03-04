<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script
	src="https://cdn.ckeditor.com/ckeditor5/31.1.0/classic/ckeditor.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
<style type="text/css">
table {
	width: 500;
	border: 1;
}

.ck.ck-editor {
	max-width: 800px;
}

.ck-editor__editable {
	height: 400px;
}

.ck-editor__editable {
	height: 400px;
}

.ck-content {
	font-size: 12px;
}
</style>
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
		<div id="editor"></div>
		<input type="submit" value="작성">
	</form>
	<a href="freeboard">목록보기</a>
</body>
<script>
ClassicEditor
  .create( document.querySelector( '#editor' ), {
	  language: "ko",
	  removePlugins: [ 'Heading' ]
  })
  .catch( error => {
    console.error( error );
  } );
</script>
</html>