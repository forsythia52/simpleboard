<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS -->
<link href="css/boardcss.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="../bootstrap/symbol.jsp"%>
	<div class="d-flex flex-column flex-shrink-0 p-3" id="sidebar">
		<ul class="nav nav-pills flex-column mb-auto">
			<li class="nav-item">
				<div style="margin: 30px">
					<strong><c:choose>
							<c:when test="${id == null}">로그인하세요</c:when>
							<c:when test="${id != null}">
								<img src="" alt="" width="32" height="32"
									class="rounded-circle me-2">${id}</c:when>
						</c:choose> </strong>
				</div> <a href="login" class="nav-link active" aria-current="page"> <svg
						class="bi pe-none me-2" width="16" height="16">
						<use xlink:href="#home"></use></svg> 로그인
			</a>
			</li>
			<li><a href="/" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16">
						<use xlink:href="#speedometer2"></use></svg> 메인화면
			</a></li>
			<li><a href="/" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="300"></svg>
			</a></li>
		</ul>
	</div>
</body>
</html>
