<%--
  Created by IntelliJ IDEA.
  User: MM
  Date: 2021-01-18
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式快速入门</title>
</head>
<body>
<%--1.向域对象中添加数据--%>
    <%request.setAttribute("username","yzl");%>
Java代码块：<%out.println(request.getAttribute("username"));%><br>
Jsp表达式:<%=request.getAttribute("username")%> <br>
El表达式:${username}
</body>
</html>
