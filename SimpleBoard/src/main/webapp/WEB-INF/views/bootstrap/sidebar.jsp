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
	<div class="d-flex flex-column flex-shrink-0 p-3 bg-light"
		style="float: left;">
		<a href="/"
			class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
			<svg class="bi pe-none me-2" width="40" height="32">
				<use xlink:href="#bootstrap"></use></svg> <span class="fs-4">Sidebar</span>
		</a>
		<hr>
		<ul class="nav nav-pills flex-column mb-auto">
			<li class="nav-item"><a href="#" class="nav-link active"
				aria-current="page"> <svg class="bi pe-none me-2" width="16"
						height="16">
						<use xlink:href="#home"></use></svg> Home
			</a></li>
			<li><a href="#" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16">
						<use xlink:href="#speedometer2"></use></svg> Dashboard
			</a></li>
			<li><a href="#" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16">
						<use xlink:href="#table"></use></svg> Orders
			</a></li>
			<li><a href="#" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16">
						<use xlink:href="#grid"></use></svg> Products
			</a></li>
			<li><a href="#" class="nav-link link-dark"> <svg
						class="bi pe-none me-2" width="16" height="16">
						<use xlink:href="#people-circle"></use></svg> Customers
			</a></li>
		</ul>
		<hr>
		<div class="dropdown">
			<a href="#"
				class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle"
				data-bs-toggle="dropdown" aria-expanded="false"> <img
				src="https://github.com/mdo.png" alt="" width="32" height="32"
				class="rounded-circle me-2"> <strong>mdo</strong>
			</a>
			<ul class="dropdown-menu text-small shadow">
				<li><a class="dropdown-item" href="#">New project...</a></li>
				<li><a class="dropdown-item" href="#">Settings</a></li>
				<li><a class="dropdown-item" href="#">Profile</a></li>
				<li><hr class="dropdown-divider"></li>
				<li><a class="dropdown-item" href="#">Sign out</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
