<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ "taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<body>
<div id = "wrapper">
	<div id = "header">
		<h2> CUSTOMER RELATIONSHIP MANAGER</h2>
	</div>
	<div id="container">
		<div id = "content">
			<table>
				<tr>
					<th>First name</tr>
					<th>Last name</tr>
					<th>Email</tr>
				<tr>
				
				<c:forEach var = "tempCustomer" items = "${customers}">
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
					</tr>
				</c:forEach>				
			</table>
		</div>
	</div>
</div>
</body>
</html>