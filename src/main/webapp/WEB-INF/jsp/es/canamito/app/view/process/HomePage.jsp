
<%
request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="cb" uri="/WEB-INF/es/canamito/app/tlds/cb.tld"%>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Header.jsp">
	<jsp:param value="P�gina principal" name="title" />
</jsp:include>

<table class="table table-striped">
	<thead>
		<tr>
			<td class="table-primary">Roles</td>
			<td class="table-primary">Correo electr�nico</td>
			<td class="table-primary">Contrase�a</td>
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