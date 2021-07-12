<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="nl">
<head>
    <link rel="stylesheet" href="../../resource/css/main.css">
    <meta charset="ISO-8859-1">
    <title>Start</title>
</head>
<body>
<main>
    <form class="formlogin" action="addaquarium">
        <input name="naam" class="input" type="text" placeholder="naam" required>
        <br>
        <input name="lengte" class="input" type="number" placeholder="lengte" required>
        <br>
        <input name="breedte" class="input" type="number" placeholder="breedte" required>
        <br>
        <input name="hoogte" class="input" type="number" placeholder="hoogte" required>
        <br>
        <input name="bodem" class="input" type="text" placeholder="bodem" required>
        <br>
        <input name="water" class="input" type="text" placeholder="water" required>
        <br>
        <button type="submit" class="button">voeg toe</button>
    </form>
        <a href="home">terug</a>
</main>
</body>
</html>