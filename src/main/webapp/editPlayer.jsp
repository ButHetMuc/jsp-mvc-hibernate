<%@ page import="butle.giuaki.entities.Player" %><%--
  Created by IntelliJ IDEA.
  User: butle
  Date: 07/04/2023
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editing player</title>
</head>
<body>
    <% Player selPlayer = (Player) session.getAttribute("selPlayer");%>
    <form action="controller">
        <input type="hidden" name="action" value="update-player"/>
        <h3>player id: <input name="id" value="<%= selPlayer.getPlayerId()%>"/></h3>
        <h3>name: <input name="playerName" value="<%= selPlayer.getName()%>"/></h3>
        <h3>age: <input name="age" value="<%= selPlayer.getAge()%>"/></h3>
        <h3>team id: <input name="teamId" value="<%= selPlayer.getTeam().getTeamId()%>"/></h3>
        <input type="submit" value="update"/>
    </form>
</body>
</html>
