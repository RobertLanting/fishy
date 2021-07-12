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
    <form class="formlogin" action="addtoebehoren">
        <input name="model" class="input" type="text" placeholder="model" required>
        <br>
        <input name="omschrijving" class="input" type="text" placeholder="omschrijving" required>
        <br>
        <button type="submit" class="button">voeg toe</button>
    </form>
    <a href="home">terug</a>
</main>
</body>
</html>