<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Ninja</title>
	</head>
	
	<body>
		
		<form:form action="/ninjas/new" method="POST" modelAttribute="nuevoNinja">
			<h1>New Ninja</h1>
			
			<label>Dojo:</label>
			<select name="dojo" id="dojo">
       			<c:forEach items="${listaDojos}" var="dojo">
             		<option value="${dojo.id}">${dojo.name}</option>
        		</c:forEach>
	  		</select><br><br>
			
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName" type="text"/><br><br>
			
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName" type="text"/><br><br>
			
			<form:label path="age">Age:</form:label>
			<form:errors path="age"/>
			<form:input path="age" type="text"/><br><br>
			
			<input type="submit" value="Create"/>
			<a href="/dojos/new">Register Dojo</a>
			
		</form:form>
		
	</body>
</html>