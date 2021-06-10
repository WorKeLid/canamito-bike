
<%
request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="cb" uri="/WEB-INF/es/canamito/app/tlds/cb.tld"%>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Header.jsp">
	<jsp:param value="${requestScope.title}" name="title" />
</jsp:include>

<div>Bienvenido a la página principal de CañamitoBike</div>

<pre>Dibujar las tablas</pre>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Footer.jsp" />