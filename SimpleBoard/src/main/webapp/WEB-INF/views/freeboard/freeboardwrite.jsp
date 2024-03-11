<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<!-- ckediter -->
<script
	src="https://cdn.ckeditor.com/ckeditor5/31.1.0/classic/ckeditor.js"></script>
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
		<div>
			<textarea name="content" id="editor"></textarea>
		</div>
		<input type="submit" value="작성">

	</form>
	<form action="imgupload" method="post">
		<input type="file" name="imgfile"> <input type="submit"
			value="업로드">
	</form>
	<a href="freeboard">목록보기</a>
</body>
<script>
// 에디터 구현
ClassicEditor
  .create( document.querySelector( '#editor' ), {
	  language: "ko",
	  removePlugins: [ 'Heading' ],
      simpleUpload:
      {
          uploadUrl: "/common/fms/ckeditor5Upload.do",
          withCredentials: true,
      },
	  extraPlugins: [MyCustomUploadAdapterPlugin],
  })
  .catch( error => {
    console.error( error );
  } );
  
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
        xhr.open('POST', '/common/fms/ckeditor5Upload.do', true);
        xhr.responseType = 'json';
    }

    _initListeners(resolve, reject, file) {
        const xhr = this.xhr;
        const loader = this.loader;
        const genericErrorText = '파일을 업로드 할 수 없습니다.'

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