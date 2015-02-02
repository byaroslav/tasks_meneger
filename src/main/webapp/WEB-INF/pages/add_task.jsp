<%@ page import="ua.artcode.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.artcode.service.UserServiceImpl" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<div id="section">

<h1>Введите описание задачи"</h1>
<form method="post" accept-charset="utf-8" action="/app/addTaskController">
  Описание задачи:<br>
  <textarea name="desc" rows="10" cols="30"></textarea>
  <br>
  Приоритет: <br>
  <select name="taskPriority">
    <option value="1">Критический</option>
    <option value="2">Высокий</option>
    <option value="3">Средний</option>
    <option value="4">Низкий</option>
  </select>
  <br>
  Выбирите исполнителя:<br>
  <% UserServiceImpl userService = (UserServiceImpl) application.getAttribute("userService");
      List<User> executors = userService.showAllUsers();
  %>
    <select name="executor">
        <%for (User u:executors){%>
            <option value="<%=u.getId()%>"><%=u.getName()%></option>
        <%}%>
    </select>
    <br>
  Кол-во запланированых часов:
  <input type="text" name="pHours" value="0">
  <br>

  <input type="submit" value="Добавить">
</form>

</div>
</body>
</html>
