<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Редактирование пользователя</title>
</head>
<body>
<h2>Редактирование пользователя: </h2>
<form action="<%=request.getContextPath()%>/view" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <label>
                    <input type="text" name="name">
                </label>
            </td>
        </tr>
        <tr>
            <td>Login:</td>
            <td>
                <label>
                    <input type="text" name="login">
                </label>
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <label>
                    <input type="text" name="email">
                </label>
            </td>
        </tr>
        <tr>
            <td>CreateDate:</td>
            <td>
                <label>
                    <input type="date" name="createDate">
                </label>
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"></td>
        </tr>
    </table>
</form>

</body>
</html>
