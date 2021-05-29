
<%
request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="cb" uri="/WEB-INF/es/canamito/app/tlds/cb.tld"%>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Header.jsp">
	<jsp:param value="Inicio de sesión" name="title" />
	<jsp:param
		value="/CanamitoBike/resources/css/es/canamito/app/css/Boostrap5/bootstrap.min.css"
		name="css" />
</jsp:include>

<div class="d-flex justify-content-center">
	<form class="w-25">
		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">Correo electrónico</label>
			<div class="col-sm-10">
				<input type="email" class="form-control">
			</div>

		</div>
		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">Contraseña</label>
			<div class="col-sm-10">
				<input type="password" class="form-control">
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Iniciar sesión</button>
	</form>
</div>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Footer.jsp">
	<jsp:param
		value="/CanamitoBike/resources/css/es/canamito/app/css/Boostrap5/bootstrap.bundle.min.js"
		name="js" />
</jsp:include>