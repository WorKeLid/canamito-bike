
<%
request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="cb" uri="/WEB-INF/es/canamito/app/tlds/cb.tld"%>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Header.jsp">
	<jsp:param value="P�gina principal" name="title" />
</jsp:include>

<div>Bienvenido a la p�gina principal de Ca�amitoBike</div>

<table class="table table-striped">
	<tr class="table-primary">
		<td class="table-primary">Celda 1.1</td>
		<td class="table-primary">Celda 2.1</td>
		<td class="table-primary">Celda 3.1</td>
	</tr>
	<tr class="table-primary">
		<td class="table-primary">Celda 1.2</td>
		<td class="table-primary">Celda 2.2</td>
		<td class="table-primary">Celda 3.2</td>
	</tr>
	<tr class="table-primary">
		<td class="table-primary">Celda 1.3</td>
		<td class="table-primary">Celda 2.3</td>
		<td class="table-primary">Celda 3.3</td>
	</tr>
</table>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Footer.jsp" />