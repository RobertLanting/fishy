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
    <h1>eigenaar : ${naam}</h1>
    <a href="login">log uit</a>
    <br>
    <h2>aquaria :</h2>
    <br>
    <button onclick="location.href='aquarium'">voeg aquarium toe</button>
    <br>
    <c:forEach items="${aquaria}" var="a">
        <div class="aqua">
        <h2>${a.naam}</h2>
            <button onclick=showInfo(${a.naam})>info</button>
            <button onclick="location.href='removeaquarium?aquarium=${a.naam}'">verwijder</button>
            <div class="info" id="${a.naam}" style="display: none">
                <button onclick=closeInfo(${a.naam})>sluit</button>
                <h3>afmetingen : B ${a.breedte} x L ${a.lengte} x H ${a.hoogte}</h3>
                <div class="boxes">
                <div class="bewoners">
                <h3>bewoners:</h3>
                <button onclick="location.href='bewoner?aquarium=${a.naam}'">voeg bewoner toe</button>
                <c:forEach items="${a.bewoners}" var="b">
                    <div class="box">
                    <p>Soortnaam : ${b.soortnaam}</p>
                    <p>Kleurnaam : ${b.kleurnaam}</p>
                    <p>Aantal : ${b.aantal}</p>
                    <p>Type : ${b.type}</p>
                    <p>Groepsdier : ${b.groepsDier}</p>
                        <button onclick="location.href='removebewoner?soortnaam=${b.soortnaam}&aquarium=${a.naam}'">verwijder</button>
                    </div>
                </c:forEach>
                </div>
                <div class="ornamenten">
                    <h3>ornamenten:</h3>
                    <button onclick="location.href='ornament?aquarium=${a.naam}'">voeg ornament toe</button>
                    <c:forEach items="${a.ornamenten}" var="o">
                        <div class="box">
                            <p>naam : ${o.naam}</p>
                            <p>omschrijvin : ${o.omschrijving}</p>
                            <p>kleur : ${o.kleur}</p>
                            <p>kanOpLuchtpomp : ${o.kanOpLuchtpomp}</p>
                            <button onclick="location.href='removeornament?naam=${o.naam}&aquarium=${a.naam}'">verwijder</button>
                        </div>
                    </c:forEach>
                </div>
            </div>
            </div>
        </div>
        <br>
    </c:forEach>
    <h2>toebehoren :</h2>
    <br>
    <button onclick="location.href='toebehoren'">voeg toebehoren toe</button>
    <br>
    <c:forEach items="${toebehoren}" var="t">
        <div class="aqua">
        <h2>${t.model} : ${t.omschrijving}</h2>
        <button onclick="location.href='removetoebehoren?toebehoor=${t.serienummer}'">verwijder</button>
        <div class="info">
            <div class="box">
                <p>model : ${t.model}</p>
                <p>omschrijving : ${t.omschrijving}</p>
                <p>serienummer : ${t.serienummer}</p>
            </div>
        </div>
    </div>
        <br>
        </c:forEach>



</main>
</body>
<script>
    if (window.location.href.indexOf("home") === -1) {
        location.href = "home"
    }

    function showInfo(id) {
        id.style.display = 'block'
    }

    function closeInfo(id) {
        id.style.display = 'none'
    }
</script>
</html>