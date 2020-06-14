<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/echoview" method="post">
    Login : <label>
    <input type="text" name="login">
</label><br/>
    Email : <label>
    <input type="text" name="email">
</label><br/>
    <input type="submit">
</form>
<br/>

<table>
    <td>login</td>
    <td>email</td>
    <%--@elvariable id="users" type="java.util.List"--%>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.email}"/></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
