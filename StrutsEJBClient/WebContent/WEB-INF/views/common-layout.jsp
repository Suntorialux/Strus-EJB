<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<tiles:insert attribute="header" />
<tiles:insert attribute="body" />
<tiles:insert attribute="footer" />
</html:html>
