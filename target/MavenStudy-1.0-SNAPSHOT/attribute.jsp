<%@ page import="com.study.User" %><%--
  Created by IntelliJ IDEA.
  User: Nevermore
  Date: 2020/7/6
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Attribute</title>
</head>
<body>
<%
    //往 application 域对象中添加属性
    application.setAttribute("username", "g-code");
//替换 application 域对象中name属性的值
    application.setAttribute("username", "G-code");
//移除 application 域对象中name属性
    application.removeAttribute("username");
//往 session 域对象中添加属性
    session.setAttribute("username", "g-code");
//替换 session 域对象中name属性的值
    session.setAttribute("username", "G-code");
//移除 session 域对象中name属性
    session.removeAttribute("username");
//往 request 域对象中添加属性
    request.setAttribute("username", "g-code");
//替换 request 域对象中name属性的值
    request.setAttribute("username", "G-code");
//移除 request 域对象中name属性
    request.removeAttribute("username");
%>

<%
    //将javabean对象绑定到Session中
    session.setAttribute("bean", new User("xxx"));
//从Session中删除javabean对象
    session.removeAttribute("bean");
%>
</body>
</html>
