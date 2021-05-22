<%@ page import="org.apache.logging.log4j.LogManager"%>
<%@ page import="org.apache.logging.log4j.Logger"%>
<%
final Logger lg = LogManager.getLogger();
lg.debug("Redirecting to " + request.getContextPath() + "/app/HomePage");
response.sendRedirect(request.getContextPath() + "/app/HomePage");
%>
