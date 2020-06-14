<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Редактировать пользователя</title>
</head>
<body>
<h2>Редактировать пользователя: </h2>

<form action="<%=request.getContextPath()%>/editsecurity" method="post">
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

</body>
</html>