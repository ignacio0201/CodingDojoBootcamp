<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- <c:out value="${2+2}"/> -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Dojo survey index</title>
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body>
        <form class="content" action="/result" method="POST">
            <label for="">Your Name:</label>
            <input type="text" name="name"><br>

            <label for="">Dojo Location:</label>
            <select name="dojoLocation" id="">
                <option value="San Jose">San Jose</option>
                <option value="San Juan">San Juan</option>
                <option value="San Sebastian">San Sebastian</option>
            </select><br>

            <label for="">Favorite Language</label>
            <select name="favoriteLanguage" id="">
                <option value="Python">Python</option>
                <option value="Javascript">Javascript</option>
                <option value="Java">Java</option>
            </select><br>

            <label for="">Comment (optional):</label><br>
            <textarea name="comment" id="" cols="30" rows="10"></textarea><br>
            
            <input type="submit" value="Button" >
        
        </form>
    </body>
</html>