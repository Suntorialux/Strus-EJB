<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="custom.tld" prefix="datalex"%>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th><bean:message key="customer.jsp.firstName" /></th>
				<th><bean:message key="customer.jsp.lastName" /></th>
				<th><bean:message key="customer.jsp.email" /></th>
				<th><bean:message key="customer.jsp.phone" /></th>
				<th><bean:message key="customer.jsp.payment.amount" /></th>
				<th><bean:message key="customer.jsp.payment.formOfPayment" /></th>
				<th><bean:message key="customer.jsp.payment.currencyCode" /></th>
			</tr>
		</thead>
		<tbody>
			<datalex:reservation component="customer" />

			<logic:iterate name="customers" id="cust" >
				<logic:iterate name="cust" property="payments" id="pay">
					<tr>
						<td><bean:write name="cust" property="firstName" /></td>
						<td><bean:write name="cust" property="lastName" /></td>
						<td><bean:write name="cust" property="email" /></td>
						<td><bean:write name="cust" property="phone" />
						<td><bean:write name="pay" property="amountPaid" /></td>
						<td><bean:write name="pay" property="typeCode" /></td>
						<td><bean:write name="pay" property="currencyCode" /></td>
					</tr>
				</logic:iterate>
			</logic:iterate>

		</tbody>
	</table>
</div>

