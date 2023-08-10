<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product Page</title>
	</head>
	
	<body>
		
		<main>
			<h1>${product.name}</h1>
			
			<h2>Categories:</h2>
			
			
	        	<ul>
	        		<c:forEach items="${product.categories}" var="category">
						<li>${category.name}</li>
					</c:forEach>
				</ul>
	        
			
			<form:form action="/products/${product.id}" method="post" modelAttribute="category_product">
				<label>Add Category:</label>
				<select name="category" id="category" required>
					<option value="" disabled selected>--Select--</option>
	       			<c:forEach items="${listaCategorias}" var="category">
	             		<option value="${category.id}">${category.name}</option>
	        		</c:forEach>
		  		</select><br><br>
		  		
		  		<input type="submit" value="Add">
			</form:form>
			
		</main>
		
	</body>
</html>