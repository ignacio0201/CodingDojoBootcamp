<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Profile Page</title>
	</head>
	
	<body>
		
		<main>
			<h1>${person.firstName} ${person.lastName}</h1>
			<p>License Number: ${person.license.number}</p>
			<p>State: ${person.license.state}</p>
			<p>Expiration Date: <fmt:formatDate value="${person.license.expirationDate}" pattern="MM/dd/yyyy" /></p> 
		</main>
		
	</body>
</html>