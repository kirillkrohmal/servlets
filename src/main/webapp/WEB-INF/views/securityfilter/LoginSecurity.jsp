<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Авторизация и аутентификации пользователя</title>
</head>
<body>
<h2>Авторизация и аутентификации пользователя: </h2>


<c:if test="${error != ''}">
    <div style="background-color: red">
        <c:out value="${error}"/>
    </div>
</c:if>

<form action="<%=request.getContextPath()%>/loginsecurity" method="post">
    <table>
        <tr>
            <td>Login:</td>
            <td>
                <label>
                    <input type="text" name="login">
                </label>
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>
                <label>
                    <input type="password" name="password">
                </label>
            </td>
        </tr>

        <tr>
            <td><input type="submit" align="center" value="Submit"></td>
        </tr>
    </table>

</form>

<ul>
    <li><a href="<%=request.getContextPath()%>/security">Создать пользователя</a></li>
</ul>

</body>
</html>
