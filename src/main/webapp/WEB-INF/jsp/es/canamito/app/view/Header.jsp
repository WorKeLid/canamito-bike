<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cb" uri="/WEB-INF/es/canamito/app/tlds/cb.tld"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<link href="${param.css}" type="text/css" rel="stylesheet">
<title>${param.title}</title>

</head>

<body>
	<nav class="navbar navbar-expand navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="${request.contextPath}/CanamitoBike/app/HomePage"> <img
				alt="Logo del club Cañamito Bike"
				src="/CanamitoBike/resources/images/cb_logo.jpg" width="30"
				height="24">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarScroll">
				<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"
					style="-bs-scroll-height: 100px;">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="${request.contextPath}/CanamitoBike/app/HomePage">Página
							principal</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${request.contextPath}/CanamitoBike/app/Login">Iniciar
							sesión</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarScrollingDropdown" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Link </a>
						<ul class="dropdown-menu"
							aria-labelledby="navbarScrollingDropdown">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Link</a></li>
				</ul>

				<div class="d-flex flex-row-reverse bd-highlight">
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">Dropdown button</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
	</nav>