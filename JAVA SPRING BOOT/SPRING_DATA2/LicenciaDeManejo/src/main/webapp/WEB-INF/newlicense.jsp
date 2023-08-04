<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New License</title>
	</head>
	
	<body>

		<main>
			<form:form action="/licenses/new" method="post" modelAttribute="newLicense">
			
				<h1>New License</h1>
	
      			<select name="person" id="person">
       				<c:forEach items="${listPersons}" var="person">
             			<option value="${person.id}">${person.firstName} ${person.lastName}</option>
        			</c:forEach>
	  			</select><br>

        		<form:label path="state">State</form:label>
        		<form:errors path="state"/>
        		<form:input path="state" type="text" /><br>

        		<form:label path="expirationDate">Expiration Date</form:label>
        		<form:errors path="expirationDate"/>
        		<input path="expirationDate" type="date" id="expirationDate" name="expirationDate"><br>

    			<input type="submit" value="Create">
				
			</form:form>
		</main>

	</body>
</html>