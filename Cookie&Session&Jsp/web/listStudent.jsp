<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="上课练习.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: MM
  Date: 2021-02-21
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="600px" border="1px">
    <tr>
        <th>学生姓名</th>
        <th>学生年龄</th>
        <th>学生成绩</th>
    </tr>
    <c:forEach items="${sessionScope.list}" var="list">
    <tr align="center">
        <td>${list.username}</td>
        <td>${list.age}</td>
        <td>${list.score}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
