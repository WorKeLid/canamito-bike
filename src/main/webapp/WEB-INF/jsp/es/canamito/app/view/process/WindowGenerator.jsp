
<%
request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="cb" uri="/WEB-INF/es/canamito/app/tlds/cb.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Header.jsp">
	<jsp:param value="${requestScope.title}" name="title" />
</jsp:include>

<cb:CBTDrawTableModel></cb:CBTDrawTableModel>

<jsp:include page="/WEB-INF/jsp/es/canamito/app/view/Footer.jsp" />