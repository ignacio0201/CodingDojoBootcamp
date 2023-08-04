<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Person</title>
	</head>
	
	<body>
		
		<main>
			<form:form action="/persons/new" method="post" modelAttribute="newPerson">
			
				<h1>New Person</h1>
				
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName"/>
				<form:input path="firstName" type="text"/><br>
				
				
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName"/>
				<form:input path="lastName" type="text"/><br>
				
				<input type="submit" value="Create">
				
			</form:form>
		</main>
		
	</body>
</html>