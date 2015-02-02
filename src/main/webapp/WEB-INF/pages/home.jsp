<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="top.jsp"%>
<div id="section">
    <p></p><p></p><p></p>
<p>Добро пожаловать,!<%= client.getName()%></p>
    <p></p>
    <p></p>
    <a href="/app/selectTasks?menu=1">Показать все задачи.</a> <br>
    <a href="/app/selectTasks?menu=2">Показать созданые мной задачи.</a> <br>
    <a href="/app/selectTasks?menu=3">Показать назначены мне задачи.</a> <br>

</div>
</body>
</html>
