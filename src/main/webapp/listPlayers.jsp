<%@ page import="java.util.List" %>
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
    <title>list players</title>
</head>
<body>
    <% List<Player> lst = (List<Player>) session.getAttribute("players"); %>
    <table align="center" border="1">
        <tr>
            <th>ID</th>
            <th>name</th>
            <th>age</th>
            <th>team</th>
        </tr>
        <% for (Player p : lst){%>
        <tr>
            <td><%= p.getPlayerId()%></td>
            <td><%= p.getName()%></td>
            <td><%= p.getAge()%></td>
            <td><%= p.getTeam().getName()%></td>
            <td>
                <a href="controller?action=edit-player-view&id=<%= p.getPlayerId()%>">edit</a>
                <a href="" onclick='if (confirm("for sure?"))
                {
                    window.open("controller?action=delete-player&id= <%= p.getPlayerId()%>");
                    window.close();
                }'>delete </a>
            </td>
        </tr>
        <% }%>
    </table>
    <a href="controller?action=new-player-view"> add new player </a>
</body>
</html>
