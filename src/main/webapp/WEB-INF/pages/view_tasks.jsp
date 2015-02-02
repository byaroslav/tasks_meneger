<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="top.jsp" %>
<div id="section">
<p><b>Спиок задач:</b></p>
<table border="1">
<tr>
    <td><p>id</p></td>
    <td><p>Дата создания</p></td>
    <td><p>Описание</p></td>
    <%--<td><p>Автор</p></td>
    <td><p>Исполнитель</p></td>
    <td><p>Статус</p></td>
    <td><p>Приоритет</p></td>--%>
</tr>


<c:forEach items="${Tasks}" var="t">
    <tr>
    <td><a href="/app/showtask?id=<c:out value="${t.id}"/>"><c:out value="${t.id}"/></a></td>
    <td><c:out value="${t.createDate}"/></td>
        <td><c:out value="${t.description}"/></td>
            </tr>
            </c:forEach>


            </table>

            <c:out value="${client}"/>



            </div>
            <div id="nav"/>
            </body>
            </html>
