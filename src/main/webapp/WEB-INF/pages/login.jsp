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
    <form class="formlogin" action="">
        <input name="voornaam" class="input" type="text" placeholder="voornaam" required>
        <br>
        <input name="achternaam" class="input" type="text" placeholder="achternaam" required>
        <br>
        <button type="submit" class="button">log in</button>
    </form>
    <a href="register" >registreer</a>
</main>
</body>
<script>
    if (window.location.href.indexOf("login") === -1) {
        location.href = "login"
    }
</script>
</html>