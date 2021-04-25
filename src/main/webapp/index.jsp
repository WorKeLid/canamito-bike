<%@ page import="org.apache.logging.log4j.LogManager" %>
<%@ page import="org.apache.logging.log4j.Logger" %>
<html>
<body>
<% 
Logger lg = LogManager.getLogger();

lg.trace("traza");
lg.debug("debug");
lg.info("info");
lg.warn("warning");
lg.error("error");
lg.fatal("fatal");

%>
<h2>Hello World!</h2>
</body>
</html>
