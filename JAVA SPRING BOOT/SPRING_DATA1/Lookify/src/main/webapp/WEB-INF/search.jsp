<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Search</title>
	</head>
	
	<body>

		<p>Songs by artist: <c:out value="${artist}"/></p>
		
		<form:form action="/search" method="get">
			<input type="search" name="artist" placeholder="Search Artist">
			<input type="submit" value="New Search" >
		</form:form>
		
		<a href="/dashboard">Dashboard</a>
		
		
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>rating</th>
					<th>actions</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${songsByArtist}" var="song">
					<tr>
						<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
						<td><c:out value="${song.rating}"/></td>
						
						<td>
							<form action="/delete/${song.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="delete" id="btn-del">
							</form>		
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</body>
	
</html>