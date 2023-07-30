<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<style>
	/* *{
		border: 1px solid black;
	} */
	#btn-del{
		border: none;
		background-color: white;
		text-decoration: underline;
		color: blue;
		padding: 0;
	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body class="fs-5">
	<!-- ENLACES -->
	<form action="/languages/${language.id}" method="post">
		<input type="hidden" name="_method" value="delete"> 
		<input type="submit" value="Delete" id="btn-del"> 
		<a href="/languages">Dashboard</a>
	</form>
	
	
	<!-- EDIT A LANGUAGE -->
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
	<input type="hidden" name="_method" value="put">
	    <p>
	        <form:label path="name" class="form-label">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name" class="form-control"/>
	    </p>
	    <p>
	        <form:label path="creator" class="form-label">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:input path="creator" class="form-control"/>
	    </p>
	    <p>
	        <form:label path="currentVersion" class="form-label">Version</form:label>
	        <form:errors path="currentVersion"/>
	        <form:input path="currentVersion" class="form-control"/>
	    </p>
   
	    <input type="submit" value="Submit" class="btn btn-primary"/>
	</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>