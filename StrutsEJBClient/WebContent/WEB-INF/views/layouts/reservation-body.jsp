<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="custom.tld" prefix="datalex"%>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th><bean:message key="reservation.jsp.code" /></th>
				<th><bean:message key="reservation.jsp.description" /></th>
				<th><bean:message key="reservation.jsp.componentTypeCode" /></th>
				<th><bean:message key="reservation.jsp.createDateTime" /></th>
				<th><bean:message key="reservation.jsp.internalStatus" /></th>
			</tr>
		</thead>
		<tbody>
			<datalex:reservation component="reservation" />
			<logic:iterate name="reservation" property="resComponents"
				id="resComp">
				<tr>
					<td><bean:write name="reservation" property="code" /></td>
					<td><bean:write name="reservation" property="description" /></td>
					<td><bean:write name="resComp" property="componentTypeCode" /></td>
					<td><bean:write name="resComp" property="createDateTime" />
					<td><bean:write name="resComp" property="internalStatus" /></td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>
</div>