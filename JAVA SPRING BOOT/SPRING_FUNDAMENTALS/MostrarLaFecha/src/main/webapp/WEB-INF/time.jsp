<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Time</title>
    <script src="js/time.js"></script>
    <link rel="stylesheet" href="css/time.css">
</head>
<body>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<h1><c:out value="${currentTime}"/></h1>
</body>
</html>