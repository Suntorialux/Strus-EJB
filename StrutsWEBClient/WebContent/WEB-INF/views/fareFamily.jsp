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
						<th><bean:message key="fareFamily.jsp.fareFamilyCode" /></th>
						<th><bean:message key="fareFamily.jsp.ancillaryAirComponentCode" /></th>
					</tr>
				</thead>
				<tbody>
					<datalex:reservation />
					<logic:iterate name="reservation" property="fareFamilies"
						id="fareF" indexId="index">
						<logic:iterate name="fareF" property="components" id="component">
						<tr>
							<td><bean:write name="index" /></td>
							<td><bean:write name="fareF" property="fareFamilyCode" /></td>
							<td><bean:write name="component" property="ancillaryAirComponentCode" /></td>
						</tr>
						</logic:iterate>
					</logic:iterate>
				</tbody>
			</table>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html:html>

