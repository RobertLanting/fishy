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
    <form class="formlogin" action="addbewoner">
        <input name="soortnaam" class="input" type="text" placeholder="soortnaam" required>
        <br>
        <input name="kleurnaam" class="input" type="text" placeholder="kleurnaam" required>
        <br>
        <input name="aantal" class="input" type="number" placeholder="aantal" required>
        <br>
        <p>groepsdier</p>
        <input name="groepsdier" class="input" type="checkbox" placeholder="groepsdier">
        <br>
        <input name="type" class="input" type="text" placeholder="type" required>
        <br>
        <button type="submit" class="button">voeg toe</button>
    </form>
    <a href="home">terug</a>
</main>
</body>
</html>