<%--
  Created by IntelliJ IDEA.
  User: Nevermore
  Date: 2020/7/5
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>message</title>
</head>
<body>
    <%=request.getAttribute("msg")%>
    <%=request.getAttribute("message")%>
<%--    隐藏表单域--%>
    <input type="hidden" name="session" value="1234">
</body>
</html>
