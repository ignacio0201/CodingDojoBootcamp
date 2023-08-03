<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lookify!</title>
		
	</head>
	
	<body>
		
		<a href="/songs/new">Add New</a>
		<a href="/search/topTen">Top Songs</a>
		
		<form action="/search" method="get">
			<input class="inputs-search" input type="search" name="artist">
			<input class="inputs-search" type="submit" value="New Search" >
		</form>
		
		
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>actions</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${allSongs}" var="song">
					<tr>
						<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
						<td><c:out value="${song.rating}"/></td>
						
						<td>
							<form action="/delete/${song.id}" method="post">
								<a id="btn-del"><input type="hidden" name="_method" value="delete"></a>
								<input type="submit" value="delete" id="btn-del">
							</form>		
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</body>
</html>