<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<nav>
	<div class="container">
		<ul class="list-inline">
			<logic:notEmpty name="user" scope="session">
				<ul class="breadcrumb">
					<li><bean:message key="login.jsp.promt.hello" /> <bean:write
							name="user" /></li>
					<li><html:link action="datalex/reservation.do">
							<bean:message key="reservation.jsp.button" />
						</html:link></li>

					<li><html:link action="datalex/customer.do">
							<bean:message key="customer.jsp.customerPage" />
						</html:link></li>
					<li><html:link action="datalex/fareFamily.do">
							<bean:message key="fareFamily.jsp.button" />
						</html:link></li>


					<li class="text-right col-sm-offset-9"><html:form
							action="/logout">
							<html:submit styleClass="btn btn-link">
								<bean:message key="login.jsp.promt.logout" />
							</html:submit>
						</html:form></li>
				</ul>
			</logic:notEmpty>

		</ul>
	</div>
</nav>