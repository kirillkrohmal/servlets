<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Все пользователи</title>
</head>
<body>
<h2>Все пользователи: </h2>

<ul>
    <li><a href="<%=request.getContextPath()%>/">Войти под новым пользователем</a></li>
</ul>

<table style="border: 1px solid black;" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
        <th>Действие</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <th><c:out value="${user.id}"/></th>
            <th><c:out value="${user.login}"/></th>
            <th><c:out value="${user.password}"/></th>
            <th><c:out value="${user.role}"/></th>

            <th>
                <a href="<%=request.getContextPath()%>/editsecurity?=${user.id}">Редактировать пользователя</a>
                <a href="<%=request.getContextPath()%>/security?=${user.id}">Создать пользователя</a>
            </th>
        </tr>
    </c:forEach>
</table>

</body>
</html>