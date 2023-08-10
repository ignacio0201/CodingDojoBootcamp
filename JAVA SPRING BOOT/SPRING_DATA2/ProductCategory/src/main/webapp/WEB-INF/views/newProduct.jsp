<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Product</title>
	</head>
	
	<body>
	
		<main>
			<form:form action="/products/new" method="post" modelAttribute="nuevoProducto">
			
				<h1>New Product</h1>
				
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name" type="text" placeholder="Ex: Mouse"/><br><br>
				
				<form:label path="description">Description:</form:label>
				<form:errors path="description"/>
				<form:textarea path="description" rows="4" cols="50" placeholder="Description..."/><br><br>
				
				<form:label path="price">Price:</form:label>
				<form:errors path="price"/>
				<form:input path="price" type="number"/><br><br>
				
				<input type="submit" value="Create">
				
			</form:form>
		</main>
	
	</body>
</html>