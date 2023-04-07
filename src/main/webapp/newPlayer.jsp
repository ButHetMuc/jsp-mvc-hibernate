<%--
  Created by IntelliJ IDEA.
  User: butle
  Date: 07/04/2023
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="controller">
        <input type="hidden" name="action" value="add-player"/>
        <h3> player name: <input name="playerName"/></h3>
        <h3> player age: <input name="age"/></h3>
        <h3> team id: <input name="teamId"/></h3>
        <input type="submit" value="save"/>
    </form>
</body>
</html>
