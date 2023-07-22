<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- <c:out value="${count}"/> -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Current visit count</title>
    <link rel="stylesheet" href="css/counter.css">
</head>
<body>
    <p>You have visited <a href="http://localhost:8080/">http://localhost:8080/</a></p>
    <a href="http://localhost:8080/">Test another visit?</a>
    <p>You can increase the counter x2 by visiting <a href="/increasecounterx2">http://localhost:8080/increasecounterx2</a></p>
    <p>Total visits: ${count} times.</p><br>
    <a id="reset_button" href="/reset">Reset Visits</a>
    
</body>
</html>