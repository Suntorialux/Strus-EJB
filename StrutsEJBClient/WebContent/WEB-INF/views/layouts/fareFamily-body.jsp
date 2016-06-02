<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="custom.tld" prefix="datalex"%>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th><bean:message key="fareFamily.jsp.fareFamilyCode" /></th>
				<th><bean:message
						key="fareFamily.jsp.ancillaryAirComponentCode" /></th>
			</tr>
		</thead>
		<tbody>
			<datalex:reservation component="fareFamily" />
			<logic:iterate name="fareFamilies" id="fareF">
				<logic:iterate name="fareF" property="components" id="component">
					<tr>
						<td><bean:write name="fareF" property="fareFamilyCode" /></td>
						<td><bean:write name="component"
								property="ancillaryAirComponentCode" /></td>
					</tr>
				</logic:iterate>
			</logic:iterate>
		</tbody>
	</table>
</div>

