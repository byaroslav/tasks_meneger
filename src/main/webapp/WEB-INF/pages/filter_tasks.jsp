<%@ page import="ua.artcode.service.UserServiceImpl" %>
<%@ page import="ua.artcode.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="top.jsp" %>
<% UserServiceImpl userService = (UserServiceImpl) application.getAttribute("userService");
    List<User> executors = userService.showAllUsers();
%>
<div id="nav">
    <form method="post" action="/app/filterTasks">
        <table>
            <tr>
                <td>Исполнитель:
            </tr>
            </td>
            <tr>
                <td>
                    <select name="executor">
                        <option value="0">Не задано</option>
                        <%for (User u : executors) {%>
                        <option value="<%=u.getId()%>"><%=u.getName()%>
                        </option>
                        <%}%>
                    </select>
            </tr>
            </td>
            <tr>
                <td>Автор:
            </tr>
            </td>
            <tr>
                <td>
                    <select name="author">
                        <option value="0">Не задано</option>
                        <%for (User u : executors) {%>
                        <option value="<%=u.getId()%>"><%=u.getName()%>
                        </option>
                        <%}%>
                    </select>
            </tr>
            </td>
            <tr>
                <td>Приоритет:
            </tr>
            </td>
            <tr>
                <td>
                    <select name="taskPriority" >
                        <option value="0">Не задано</option>
                        <option value="1">Критический</option>
                        <option value="2">Высокий</option>
                        <option value="3">Средний</option>
                        <option value="4">Низкий</option>
                    </select>
            </tr>
            </td>
            <tr>
                <td>Статус задачи:
            </tr>
            </td>
            <tr>
                <td>
                    <select name="taskState">
                        <option value="0">Не задано</option>
                        <option value="1">Новая</option>
                        <option value="2">В работе</option>
                        <option value="3">Закрыта</option>
                        <option value="4">Вновь открыта</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Поиск"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
