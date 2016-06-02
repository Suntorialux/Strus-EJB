<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<html:html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<tiles:insert definition="company-template">
			<tiles:put name="body" value="/WEB-INF/views/layouts/customer-body.jsp"/>
		</tiles:insert>
	</div>
</body>
</html:html>
