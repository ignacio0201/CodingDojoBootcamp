<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<style>
	*{
		border: 1px solid black;
	}
	#btn-del{
		border: none;
		background-color: white;
		text-decoration: underline;
		color: blue;
		padding: 0;
	}
</style>
</head>
<body>
	
	<div class="container fs-1">
		<div class="col-12">
			<a href="/languages">Dashboard</a>

			<p class="mt-5"><c:out value="${language.name}"/></p>
			<p class="mb-6"><c:out value="${language.creator}"/></p>
			<p class="mb-6"><c:out value="${language.currentVersion}"/></p>
			
			<form action="/languages/${language.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete" id="btn-del" class="mb-4"><br>
				<a href="/languages/edit/${language.id}">Edit</a>
			</form>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>