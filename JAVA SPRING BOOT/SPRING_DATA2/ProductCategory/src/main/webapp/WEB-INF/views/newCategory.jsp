<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Category</title>
	</head>
	
	<body>
	
		<main>
			<form:form action="/categories/new" method="post" modelAttribute="nuevaCategoria">
			
				<h1>New Category</h1>
				
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name" type="text" placeholder="Ex: Gaming"/><br><br>
				
				<input type="submit" value="Create">
				
			</form:form>
		</main>
	
	
	</body>
</html>