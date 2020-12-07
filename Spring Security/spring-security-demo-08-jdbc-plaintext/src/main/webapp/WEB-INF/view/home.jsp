<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>WELCOME</h2>
	<p>Home Page</p>
	<hr>
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role:
		<security:authentication property="principal.authorities" />
	</p>

	<hr>

	<security:authorize access="hasRole('MANAGER')">

		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				meeting</a> (Only for manager peeps)
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">

		<hr>
		<a href="${pageContext.request.contextPath}/systems">Leadership
			meeting</a> (Only for admin peeps)
	<hr>
	</security:authorize>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>