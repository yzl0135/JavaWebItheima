<%@ page import="bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: MM
  Date: 2021-01-18
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式获取不同类型数据</title>
</head>
<body>
<%pageContext.setAttribute("num",10);%>
<%--1.获取基本数据类型--%>
${num}<br>s
<%--2.获取自定义对象类型--%>
<%
    Student s=new Student("yzl",20);
    pageContext.setAttribute("student",s);
%>
${student}<br>
<%--EL表达式中没有空指针异常--%>
<%--EL表达式中没有索引越界异常--%>
<%--EL表达式中没有字符串拼接--%>
<%--stu.name 实现原理 getName()--%>
${student.name}<br>
${student.age}<br>
<%--3.获取数组类型--%>
<%
    int[] arr={1,2,3,4,5};
    pageContext.setAttribute("array",arr);
%>
${array}<br>
${array[0]}<br>
${array[1]}<br>
${array[2]}<br>
<%--4.获取List集合--%>
<%
    ArrayList<String> list=new ArrayList<>();
    list.add("yzl");
    list.add("lhy");
    list.add("lqy");
    pageContext.setAttribute("list",list);
%>
${list}<br>
${list[0]}<br>
${list[1]}<br>
${list[2]}<br>
<%--5.获取Map集合--%>
<%
    HashMap<Integer,String> hs=new HashMap<>();
    hs.put(1,"yzl");
    hs.put(2,"lhy");
    hs.put(3,"lqy");
    pageContext.setAttribute("map",hs);
%>
${map}<br>
${map.keySet()}<br>
${map.values()}<br>
</body>
</html>
