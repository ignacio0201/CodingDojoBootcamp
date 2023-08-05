<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Dojo</title>
	</head>
	
	<body>

		<form:form action="/dojos/new" method="POST" modelAttribute="nuevoDojo">
			<h1>New Dojo</h1>
			
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name" type="text"/><br><br>
			
			<input type="submit" value="Create"/>
			
			<a href="/ninjas/new">Register Ninja</a>
		</form:form>

	</body>
</html>