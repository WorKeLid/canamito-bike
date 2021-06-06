<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cb" uri="/WEB-INF/es/canamito/app/tlds/cb.tld"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="/CanamitoBike/resources/css/es/canamito/app/bootstrap-5/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<link
	href="/CanamitoBike/resources/images/es/canamito/app/icons-1.5.0/font/bootstrap-icons.css"
	type="text/css" rel="stylesheet">
<link
	href="/CanamitoBike/resources/css/es/canamito/app/canamitoCustom.css"
	type="text/css" rel="stylesheet">
<title>${param.title}</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/CanamitoBike/">Cañamito Bike</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 w-100">

<!-- 					<li class="nav-item"><a class="nav-link active" -->
<!-- 						aria-current="page" href="#">Link 1</a></li> -->

<!-- 					<li class="nav-item dropdown"> -->
<!-- 			            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"> <span class="nav-label">Services</span> <span class="caret"></span></a> -->
<!-- 			            <ul class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
<!-- 			                <li class="nav-item"><a class="dropdown-item" href="#">Service A</a></li> -->
<!-- 			                <li class="nav-item"><a class="dropdown-item" href="#">Service B</a></li> -->
<!-- 			                <li class="dropdown-submenu"> -->
<!-- 			                    <a class="dropdown-item dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Service C</a> -->
<!-- 			                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
<!-- 			                        <li class="nav-item"><a class="dropdown-item" href="#">Service C1</a></li> -->
<!-- 			                        <li class="nav-item"><a class="dropdown-item" href="#">Service C2</a></li> -->
<!-- 			                        <li class="nav-item"><a class="dropdown-item" href="#">Service C3</a></li> -->
<!-- 			                        <li class="nav-item"><a class="dropdown-item" href="#">Service C4</a></li> -->
<!-- 			                        <li class="nav-item"><a class="dropdown-item" href="#">Service C5</a></li> -->
<!-- 			                    </ul> -->
<!-- 			                </li> -->
<!-- 			            </ul> -->
<!-- 			        </li> -->
					<cb:CBTDrawMenuItems></cb:CBTDrawMenuItems>

					<c:choose>
						<c:when test="${not empty sessionScope.user}">
							<li
								class="nav-item dropdown flex-fill d-flex justify-content-end"><a
								class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-bs-toggle="dropdown" aria-expanded="false">
									${sessionScope.user.email}</a>
								<ul class="dropdown-menu dropdown-menu-end"
									aria-labelledby="navbarDropdown">
									<li><a class="dropdown-item"
										href="${request.contextPath}/CanamitoBike/app/Preferences">Preferencias</a></li>
									<li><hr class="dropdown-divider" /></li>
									<li><a class="dropdown-item"
										href="${request.contextPath}/CanamitoBike/app/Logout">Cerrar
											sesión</a></li>
								</ul></li>
						</c:when>
						<c:otherwise>
							<li
								class="nav-item dropdown flex-fill d-flex justify-content-end">
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-primary"
									data-bs-toggle="modal" data-bs-target="#exampleModal">
									Iniciar sesión</button> <!-- Modal -->
								<div class="modal fade" id="exampleModal" tabindex="-1"
									aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Inicio
													de sesión</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<form action="/CanamitoBike/app/Login" method="post">
												<div class="modal-body">

													<div class="mb-3 align-items-center">
														<label for="email" class="col-form-label">Correo
															electrónico: </label> <input type="email" id="email"
															name="input_email" class="form-control">
													</div>

													<div class="mb-3 align-items-center">
														<label for="password" class="col-form-label">Contraseña:
														</label> <input type="password" id="password"
															name="input_password" class="form-control">
													</div>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Cerrar</button>
													<button type="submit" class="btn btn-primary">Iniciar
														sesión</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>