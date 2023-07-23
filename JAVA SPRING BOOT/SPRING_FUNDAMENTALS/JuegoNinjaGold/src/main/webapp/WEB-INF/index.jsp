<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- <c:out value="${2+2}"/> -->

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Ninja Gold Game</title>
	<link rel="stylesheet" href="css/style_index.css">
	<script src="js/scroll.js"></script>

</head>
<body>
	<!-- CONTAINER -->
	<div class="contenedor">
		<!-- HEADER -->
		<header class="header">
			<div class="header_content">
				<h1 class="title-yourgold">Your Gold:</h1>
				<div class="gold">${gold}</div>
				<form action="/Reset" method="POST">
					<button class="reset_button">Reset</button>
				</form>
			</div>
		</header>
		
		<!-- MAIN -->
		<main>
			<div class="findgold_box_main">
				<form class="form_boxs" action="/Farm" method="POST">
					<article class="findgold_boxs">
						<h2 class="findgold_boxs-titles">Farm</h2>
						<p class="findgold_boxs-inf">(earns 10-20 gold)</p>
						<button class="findgold_boxs-button">Find Gold!</button>
					</article>

				</form>

				<form class="form_boxs" action="/Cave" method="POST">
					<article class="findgold_boxs">
						<h2 class="findgold_boxs-titles">Cave</h2>
						<p class="findgold_boxs-inf">(earns 5-10 gold)</p>
						<button class="findgold_boxs-button">Find Gold!</button>
					</article>
				</form>

				<form class="form_boxs" action="/House" method="POST">
					<article class="findgold_boxs">
						<h2 class="findgold_boxs-titles">House</h2>
						<p class="findgold_boxs-inf">(earns 2-5 gold)</p>
						<button class="findgold_boxs-button">Find Gold!</button>
					</article>
				</form>

				<form class="form_boxs" action="/Casino" method="POST">
					<article class="findgold_boxs">
						<h2 class="findgold_boxs-titles-casino">Casino!</h2>
						<p class="findgold_boxs-inf">(earns/takes <br> 0-50 gold)</p>
						<button class="findgold_boxs-button">Find Gold!</button>
					</article>
				</form>
			</div>
			<!-- FOOTER -->
			<footer class="footer">
				<h2 class="footer_title">Activities:</h2>
				<ul class="lista">
					<c:forEach var="register" items="${datesArray}">
						<li data-status="${register.contains('earned') ? 'earned' : (register.contains('lost') ? 'lost' : '')}">
							<c:out value="${register}" />
						</li>
					</c:forEach>
				</ul>
			</footer>
		</main>

	</div>

</body>
</html>