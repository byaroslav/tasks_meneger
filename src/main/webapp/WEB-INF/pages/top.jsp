<%@ page import="ua.artcode.model.User" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%User client = (User)session.getAttribute("client");%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <title>Джира</title>
</head>

<body>

<div id="header">
    <p>Вы вошли под пользователем:<%= client.getName()%> <br>
        <a href="/menu/addTask">1.Добавить задачу</a>
        <a href="/menu/home">2.Домашняя страница</a>
        <a href="/menu/filterTasks">2.Фильтр задач</a></p>
</div>







