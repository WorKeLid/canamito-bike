<%@ page import="org.apache.logging.log4j.LogManager"%>
<%@ page import="org.apache.logging.log4j.Logger"%>
<%
final Logger lg = LogManager.getLogger();
lg.debug("Redirecting to " + "/app/HomePage");
response.sendRedirect("/app/HomePage");
%>
