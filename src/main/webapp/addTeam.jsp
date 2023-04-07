<%--
  Created by IntelliJ IDEA.
  User: butle
  Date: 07/04/2023
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Team</title>
</head>
<body>
  <form action="controller">
    <input type="hidden" name="action" value="add-team"/>
    <h3> team name: <input name="teamName"/></h3>
    <h3> location: <input name="location"/></h3>
    <input type="submit" value="save">
  </form>
</body>
</html>
