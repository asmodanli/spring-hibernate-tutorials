<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<link type = "text/css"
			rel = "stylesheet"
			href = "${pageContext.request.contextPath}/resources/css/style.css"
	/>

<title>Customers</title>
</head>
<body>
	<div id = "wrapper">
		<div id = "header">
			<h2> CUSTOMER RELATIONSHIP MANAGER</h2>
		</div>
	</div>
		<div id="container">
			<div id = "content">
			
			<!--  new button: add customer -->
			
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormAdd'; return false;"
				class="add-button"
				/>
			
				<table>
					<tr>
						<th>First name</th>
						<th>Last name</th>
						<th>Email</th>
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
</body>
</html>