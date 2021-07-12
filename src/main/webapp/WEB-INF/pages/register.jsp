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
    <form class="formlogin" action="login">
        <input name="regvoornaam" class="input" type="text" placeholder="voornaam" required>
        <br>
        <input name="regachternaam" class="input" type="text" placeholder="achternaam" required>
        <br>
        <button type="submit" class="button">registreer</button>
    </form>
    <a href="login" >log in</a>
    <h2>${error}</h2>
</main>

</body>
</html>