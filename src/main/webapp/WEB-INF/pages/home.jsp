<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="top.jsp"%>
<div id="section">
    <p></p><p></p><p></p>
<p>Добро пожаловать, <%= client.getName()%>!</p>
    <p/>
    <p/>
    <a href="/app/filterTasks?author=<c:out value="${client.id}"/>">Показать созданые мной задачи.</a> <br>
    <p/>
    <a href="/app/filterTasks?executor=<c:out value="${client.id}"/>">Показать назначены мне задачи.</a> <br>

</div>
</body>
</html>
