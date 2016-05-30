<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="custom.tld" prefix="datalex"%>


<html:html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>№</th>
						<th><bean:message key="reservation.jsp.code" /></th>
						<th><bean:message key="reservation.jsp.description" /></th>
						<th><bean:message key="reservation.jsp.componentTypeCode" /></th>
						<th><bean:message key="reservation.jsp.createDateTime" /></th>
						<th><bean:message key="reservation.jsp.internalStatus" /></th>
					</tr>
				</thead>
				
			</table>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html:html>

