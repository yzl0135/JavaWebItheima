<%--
  Created by IntelliJ IDEA.
  User: MM
  Date: 2021-02-21
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <c:if test="${sessionScope.username eq null}">
       <a href="${pageContext.request.contextPath}/login.jsp">请登录</a>
   </c:if>

   <c:if test="${sessionScope.username ne null}">
    <a href="${pageContext.request.contextPath}/addStudent.jsp">添加学生</a>
    <a href="${pageContext.request.contextPath}/find_test">查看学生</a>
   </c:if>
</body>
</html>
