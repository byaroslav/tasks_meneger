<%@include file="top.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<div id="section">
  <p><b>Спиок задач:</b></p>
  <table border="1">
    <tr>
      <td><p>id</p></td>
      <td><p>Дата создания</p></td>
      <td><p>Описание</p></td>
      <td><p>Автор</p></td>
      <td><p>Исполнитель</p></td>
      <td><p>Статус</p></td>
      <td><p>Приоритет</p></td>

    </tr>


<c:forEach items="${Tasks}" var="t">
   <tr>
      <td><a href="/app/showtask?id=<c:out value="${t.id}"/>"><c:out value="${t.id}"/></a></td>
      <td><c:out value="${t.createDate}"/></td>
      <td><c:out value="${t.description}"/></td>
      <td><c:out value="${t.author.name}"/></td>
      <td><c:out value="${t.executor.name}"/></td>
      <td><c:out value="${t.state}"/></td>
      <td><c:out value="${t.priority}"/></td>
   </tr>
</c:forEach>
</table>
<c:set var="beg" value="1"/>
<c:set var="end" value="10"/>
<c:set var="numberOfLinks" value="${numberOfTasks/15}"/>
  <c:forEach var="i" begin="${beg}" end="${numberOfLinks}">
  <a href="/app/page?beg=<c:out value="${beg}"/>">[<c:out value="${beg}"/>....<c:out value="${end}"/>]</a>
  <c:set var="beg" value="${beg+15}"/>
  <c:set var="end" value="${end+15}"/>
  </c:forEach>
  <c:if test="${numberOfLinks < numberOfTasks}">
    <a href="/app/page?beg=<c:out value="${beg}"/>">[<c:out value="${beg}"/>....<c:out value="${numberOfTasks}"/>]</a>
  </c:if>
</div>
<div id="nav"/>
</body>
</html>
