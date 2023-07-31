<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- <c:out value="${5+5}"/> -->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Dojo Survey Index</title>
        <link rel="stylesheet" href="css/result.css">
    </head>
    <body>
       
        <div class="content">
			<h1>Submitted Info</h1>
            <p>Name: <c:out value="${name}"/></p>
            <p>Dojo Location: <c:out value="${dojoLocation}"/> </p>
            <p>Favorite Language: <c:out value="${favoriteLanguage}"/></p>
            <p>Comment: <c:out value="${comment}"/></p>
            <a href="/"><input type="submit" value="Go Back"></a>
        </div>
      
    </body>
</html>