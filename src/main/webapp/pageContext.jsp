<%--
  Created by IntelliJ IDEA.
  User: Nevermore
  Date: 2020/7/6
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext</title>
</head>
<body>
<%
    pageContext.setAttribute("name", "pageContext");
    request.setAttribute("name", "request");
    session.setAttribute("name", "session"); // 会话不销毁时，session中的值会一直累加，如name、name1、name2...所以测试application时，需要关闭浏览器
    application.setAttribute("name", "application");
%>
<%
    // 查找name属性，按照顺序"page→request→session→application"在这四个对象中去查找
    String name = (String) pageContext.findAttribute("name");
%>
<hr />
<h3>
    pageContext.findAttribute方法查找到的属性值来源于：<%=name%>
</h3>

<%
    //此时相当于往session对象中存放了一个name属性，等价于 session.setAttribute
    pageContext.setAttribute("mes", "无语",
            PageContext.SESSION_SCOPE);
%>
<%
    //取得session对象的属性，使用pageContext对象获取
    String refName1 = (String) pageContext.getAttribute("mes",
            PageContext.SESSION_SCOPE);
    String refName2 = (String) session.getAttribute("mes");
%>
<h1>取出存放在session对象中的属性值：</h1>
<p>第一种做法：使用pageContext.getAttribute("attributeName",
    PageContext.SESSION_SCOPE); 去取出session对象中值</p>
<h3>
    msg：<%=refName1%>
</h3>
<p>第二种做法：使用session.getAttribute("attributeName"); 去取出session对象中值
</p>
<h3>
    msg：<%=refName2%>
</h3>

<!-- 引入 -->
使用pageContext的include方法引入资源
<%
pageContext.include("/message.jsp");
%>
<!-- 跳转 -->
<%
    // 使用pageContext的forward方法跳转
    pageContext.forward("/error.jsp");
    // 等 同于request.getRequestDispatcher("/error.jsp").forward(request,response);
%>
</body>
</html>
