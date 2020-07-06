<%--
  Created by IntelliJ IDEA.
  User: Nevermore
  Date: 2020/7/6
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         errorPage="/error.jsp" pageEncoding="UTF-8"%>
<html>
<head>
    <title>errorPage</title>
</head>
<body>
<%
    // 这行代码肯定会出错，因为除数是0，一运行就会抛出异常
    int x = 1/0;
%>
</body>
</html>
