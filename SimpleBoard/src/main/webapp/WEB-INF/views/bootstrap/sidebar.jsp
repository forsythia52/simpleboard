<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
			<li class="nav-item"><a href="login" class="nav-link active"
				aria-current="page"> <svg class="bi pe-none me-2" width="16"
						height="16">
						<use xlink:href="#home"></use></svg> 로그인
			</a></li>
			<li><a href="/" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16">
						<use xlink:href="#speedometer2"></use></svg> 메인화면
			</a></li>
			<li><a href="/" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16"></svg>
			</a></li>
						<li><a href="/" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16"></svg>
			</a></li>
						<li><a href="/" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16"></svg>
			</a></li>
						<li><a href="/" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16"></svg>
			</a></li>
						<li><a href="/" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16"></svg>
			</a></li>
						<li><a href="/" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16"></svg>
			</a></li>
						<li><a href="/" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16"></svg>
			</a></li>
						<li><a href="/" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16"></svg>
			</a></li>
		</ul>
		<hr>
		<div class="dropdown">
			<a href="#"
				class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle"
				data-bs-toggle="dropdown" aria-expanded="false"> <img
				src="https://github.com/mdo.png" alt="" width="32" height="32"
				class="rounded-circle me-2"> <strong>닉네임</strong>
			</a>
			<ul class="dropdown-menu text-small shadow">
				<li><a class="dropdown-item" href="#">New project...</a></li>
				<li><a class="dropdown-item" href="#">Settings</a></li>
				<li><a class="dropdown-item" href="#">Profile</a></li>
				<li><hr class="dropdown-divider"></li>
				<li><a class="dropdown-item" href="/logout">로그아웃</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
