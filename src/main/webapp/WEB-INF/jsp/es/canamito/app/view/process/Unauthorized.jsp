
<%
request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="cb" uri="/WEB-INF/es/canamito/app/tlds/cb.tld"%>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Header.jsp">
	<jsp:param value="Acceso no autorizado" name="title" />
	<jsp:param
		value="/CanamitoBike/css/es/canamito/app/css/Boostrap5/bootstrap.min.css"
		name="css" />
</jsp:include>

<div class="d-flex justify-content-center">
	<p>La p�gina a la que est�s intentando acceder no existe o no est�s
		autorizado
	<p>
		<a href="${request.contextPath}/CanamitoBike/app/HomePage">Volver a la
			p�gina principal</a>
</div>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Footer.jsp">
	<jsp:param
		value="/CanamitoBike/css/es/canamito/app/css/Boostrap5/bootstrap.bundle.min.js"
		name="js" />
</jsp:include>