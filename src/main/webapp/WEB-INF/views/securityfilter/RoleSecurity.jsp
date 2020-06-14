<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Выбор роли</title>
</head>
<body>
<h2>Выбор роли:</h2>
<form action="<%=request.getContextPath()%>/rolesecurity" method="post">
    <table>
        <tr>
            <td>
                <select name="user">
                    <option value="volvo">Admin</option>
                    <option value="saab">User</option>
                </select>
                <br><br>
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"></td>
        </tr>
    </table>
</form>

</body>
</html>