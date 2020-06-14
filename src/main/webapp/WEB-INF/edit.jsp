<%--
  Created by IntelliJ IDEA.
  User: Comp
  Date: 31.05.2020
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/post/save" method="post">
    <div class="form-group">
        <label>Имя</label>
        <input type="text" class="form-control" name="name">
    </div>
    <button type="submit" class="btn btn-primary">Сохранить</button>
</form>
</body>
</html>
