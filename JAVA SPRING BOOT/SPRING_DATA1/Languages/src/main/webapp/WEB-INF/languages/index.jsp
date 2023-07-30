<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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

	<title>Languages</title>
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<!--SHOW ALL LANGUAGES -->
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allLanguages}" var="language">
					<tr>
						<td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
						<td><c:out value="${language.creator}"/></td>
						<td><c:out value="${language.currentVersion}"/></td>
						
						<td>
							<form action="/languages/${language.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="delete" id="btn-del">
								<a href="/languages/edit/${language.id}">edit</a>
							</form>		
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="col-12 d-flex justify-content-center">
			<!-- CREATE A NEW LANGUAGE -->
			<form:form action="/languages" method="post" modelAttribute="newLanguage" class="text-center">
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
		

	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</body>
</html>