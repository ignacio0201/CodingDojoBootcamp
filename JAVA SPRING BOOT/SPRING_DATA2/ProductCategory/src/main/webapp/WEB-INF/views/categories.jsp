<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Category Page</title>
	</head>
	
	<body>
	
		<main>
			<h1>${category.name}</h1>
			
			<h2>Products:</h2>
			
			
	        	<ul>
	        		<c:forEach items="${category.products}" var="product">
						<li>${product.name}</li>
					</c:forEach>
				</ul>
	        
			
			<form:form action="/categories/${category.id}" method="post" modelAttribute="category_product">
				<label>Add Product:</label>
				<select name="product" id="product" required>
					<option value="" disabled selected>--Select--</option>
	       			<c:forEach items="${listaProductos}" var="product">
	             		<option value="${product.id}">${product.name}</option>
	        		</c:forEach>
		  		</select><br><br>
		  		
		  		<input type="submit" value="Add">
			</form:form>
			
		</main>
	
	</body>
</html>