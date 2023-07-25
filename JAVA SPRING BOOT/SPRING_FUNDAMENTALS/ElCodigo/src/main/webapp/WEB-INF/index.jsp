<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- <c:out value="${2+2}"/> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secret Code</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<div class="content">
		<form action="/" method="POST">
			<p class="error"> <c:out value="${error}"/> </p>
			<p class="codeQuestion">What is the code?</p>
			<input class="input-password" type="password" name="password"></input>
			<input class="button" type="submit" value="Try Code"></input>
		</form>
	</div>
</body>
</html>