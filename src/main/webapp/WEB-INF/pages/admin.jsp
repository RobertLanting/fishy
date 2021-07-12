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
    <h1>admin</h1>
    <a href="login">log uit</a>
    <br>
    <c:forEach items="${eigenaren}" var="e">
        <c:if test="${e.voornaam != 'admin'}">
        <div class="user">
            <p>${e.voornaam} ${e.achternaam}</p>
            <button onclick="location.href='removeeigenaar?eigenaar=${e.voornaam}'">verwijder</button>
        </div>
        <br>
        </c:if>
    </c:forEach>
</main>
</body>
<script>
    if (window.location.href.indexOf("admin") === -1) {
        location.href = "admin"
    }
</script>
</html>