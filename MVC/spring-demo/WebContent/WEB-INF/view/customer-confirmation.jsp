<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation</title>
</head>
<body>
	Customer is confirmed: ${customer.firstName} ${customer.lastName}
	
	<br><br>
	
	Free passes: ${customer.freePasses}
	
	Postal code: ${customer.postalCode}
	
	Course code: ${customer.courseCode}
	
</body>
</html>