<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Регистрация</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<table border="1">
    <td>id: </td>
    <td>name: </td>
    <td>login: </td>
    <td>email: </td>
    <td>createDate: </td>
    <td>Выбор действия: </td>

    <c:forEach items="${users}" var="user" varStatus="status">
    <tr>
        <td>"${user.id}"</td>
        <td>"${user.name}"</td>
        <td>"${user.login}"</td>
        <td>"${user.email}"</td>
        <td>"${user.createDate}"</td>

        <td>
            <a href="<%=request.getContextPath()%>/views/cruduser/UpdateUsers.jsp?id=${user.id}">Редактировать пользователя</a>
            <a href="<%=request.getContextPath()%>/delete?id=${user.id}">Удалить пользователя</a>
        </td>
    </tr>
    </c:forEach>

<ul>
    <li><a href="<%=request.getContextPath()%>/views/cruduser/CreateUsers.jsp">Добавить пользователя</a></li>
</ul>

</body>
</html>
