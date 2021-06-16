
<%
request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="cb" uri="/WEB-INF/es/canamito/app/tlds/cb.tld"%>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Header.jsp">
	<jsp:param value="Página principal" name="title" />
</jsp:include>

<table class="table table-striped">
	<thead>
		<tr>
			<td class="table-primary">Roles</td>
			<td class="table-primary">Correo electrónico</td>
			<td class="table-primary">Contraseña</td>
		</tr>
	</thead>
	<tr class="table-primary">
		<td class="table-primary">Administrador, Usuario</td>
		<td class="table-primary">workelid@gmail.com</td>
		<td class="table-primary">canamito</td>
	</tr>
	<tr class="table-primary">
		<td class="table-primary">Usuario</td>
		<td class="table-primary">workelid+padre@gmail.com</td>
		<td class="table-primary">canamito</td>
	</tr>
</table>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Footer.jsp" />