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
	<form action="/freeboardwrite" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>작성자:</td>
				<td>${id}</td>
				<td><input type="hidden" name="userid" value="${id}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input name="boardtitle" size="100"></td>
			</tr>
			<tr>
				<td>File to upload:</td>
				<td><input type="file" name="file" /></td>
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
	language:'ko',
	removePlugins : [ 'Heading' ],
	extraPlugins: [MyCustomUploadAdapterPlugin]
}).then(editor => {
    window.editor = editor;
}).catch( error => {
    console.error( error );
});

	// 이미지 업로드
	class UploadAdapter {
    constructor(loader) {
        this.loader = loader;
    }

    upload() {
        return this.loader.file.then( file => new Promise(((resolve, reject) => {
            this._initRequest();
            this._initListeners( resolve, reject, file );
            this._sendRequest( file );
        })))
    }

    _initRequest() {
        const xhr = this.xhr = new XMLHttpRequest();
        xhr.open('POST', 'http://localhost:8000/imgupload', true);
        xhr.responseType = 'json';
    }

    _initListeners(resolve, reject, file) {
        const xhr = this.xhr;
        const loader = this.loader;
        const genericErrorText = '이미지 업로드 실패'

        xhr.addEventListener('error', () => {reject(genericErrorText)})
        xhr.addEventListener('abort', () => reject())
        xhr.addEventListener('load', () => {
            const response = xhr.response
            if(!response || response.error) {
                return reject( response && response.error ? response.error.message : genericErrorText );
            }

            resolve({
                default: response.url
            })
        })
    }

    _sendRequest(file) {
        const data = new FormData()
        data.append('upload',file)
        this.xhr.send(data)
    }
}
	
	// 어댑터 연결
	function MyCustomUploadAdapterPlugin(editor) {
    editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
        return new UploadAdapter(loader)
    }
}
	
	
</script>
</html>