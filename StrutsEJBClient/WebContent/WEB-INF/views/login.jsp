<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html:html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title><bean:message key="login.jsp.title" /></title>
</head>
<body>
	<div class="container">
		<h2 class="col-sm-offset-3">
			<bean:message key="login.jsp.heading" />
		</h2>
		<html:form styleClass="form-horizontal" action="/login" focus="login">
			<div class="form-group">
				<label for="inputLogin" class="col-sm-4 control-label"> <bean:message
						key="login.jsp.prompt.login" />
				</label>
				<div class="col-sm-4">
					<html:text property="login" styleClass="form-control col-sm-3"
						styleId="inputLogin" />
				</div>
				<div class="text-danger col-sm-3">
					<html:errors property="login" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-sm-4 control-label"> <bean:message
						key="login.jsp.prompt.password" />
				</label>
				<div class="col-sm-4">
					<html:password property="password"
						styleClass="form-control col-sm-3" styleId="inputPassword" />
				</div>
				<div class="text-danger col-sm-3">
					<html:errors property="password" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-5 col-sm-offset-6">
					<html:submit styleClass="btn btn-success">
						<bean:message key="login.jsp.prompt.submit" />
					</html:submit>
				</div>
			</div>
		</html:form>
		<html:form action="/changeLocale">
			<html:submit property="language" styleClass="btn btn-success"><bean:message key="login.jsp.promt.english" /></html:submit>
			<html:submit property="language" styleClass="btn btn-success"><bean:message key="login.jsp.promt.russian" /></html:submit>
		</html:form>
	</div>
</body>
</html:html>
