<%@ page import="java.util.List" %>
<%@ page import="butle.giuaki.entities.Team" %><%--
  Created by IntelliJ IDEA.
  User: butle
  Date: 07/04/2023
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Team</title>
</head>
<body>
    <% List<Team> lst = (List<Team>) session.getAttribute("teams");%>
    <table align="center" border="1">
        <tr>
            <th>ID</th>
            <th>name</th>
            <th>location</th>
        </tr>
        <% for (Team t : lst) { %>
        <tr>
            <td> <%= t.getTeamId() %></td>
            <td> <%= t.getName() %></td>
            <td> <%= t.getLocation() %></td>
        </tr>
        <% } %>
    </table>
    <a href="controller?action=add-team-view">add new team</a>

</body>
</html>
