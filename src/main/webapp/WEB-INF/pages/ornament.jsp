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
    <form class="formlogin" action="addornament">
        <input name="naam" class="input" type="text" placeholder="naam" required>
        <br>
        <input name="omschrijving" class="input" type="text" placeholder="omschrijving" required>
        <br>
        <input name="kleur" class="input" type="text" placeholder="kleur" required>
        <br>
        <p>kan op luchtpomp</p>
        <input name="kanopluchtpomp" class="input" type="checkbox" placeholder="kan op luchtpomp">
        <br>
        <button type="submit" class="button">voeg toe</button>
    </form>
    <a href="home">terug</a>
</main>
</body>
</html>