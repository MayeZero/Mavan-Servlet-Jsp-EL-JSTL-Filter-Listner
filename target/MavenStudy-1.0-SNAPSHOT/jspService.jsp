<%--
  Created by IntelliJ IDEA.
  User: Nevermore
  Date: 2020/7/6
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,java.io.*,java.sql.*"%>
<%--<%@ page--%>
<%--        [ language="java" ]--%>
<%--                [ extends="package.class" ]--%>
<%--                [ import="{package.class | package.*}, ..." ]--%>
<%--                [ session="true | false" ]--%>
<%--                [ buffer="none | 8kb | sizekb" ]--%>
<%--                [ autoFlush="true | false" ]--%>
<%--                [ isThreadSafe="true | false" ]--%>
<%--                [ info="text" ]--%>
<%--                [ errorPage="relative_url" ]--%>
<%--                [ isErrorPage="true | false" ]--%>
<%--                [ contentType="mimeType [ ;charset=characterSet ]" | "text/html ;--%>
<%--                charset=ISO-8859-1" ]--%>
<%--[ pageEncoding="characterSet | ISO-8859-1" ]--%>
<%--[ isELIgnored="true | false" ]--%>
<%--%>--%>
<html>
<head>
    <title>JspService</title>
</head>
<body>
<%--jsp表达式--%>
<%=new java.util.Date()%>

<%--jsp脚本片段--%>
<%
    int sum = 0;// 声明变量
    /*编写语句*/
    for (int i = 1; i <= 100; i++) {
        sum += i;
    }
    out.println("<h1>Sum=" + sum + "</h1>");
%>

<%
    session.setAttribute("name", "session对象");//使用session对象,设置session对象的属性
    out.print(session.getAttribute("name") + "<br/>");//获取session对象的属性
    pageContext.setAttribute("name", "pageContext对象");//使用pageContext对象,设置pageContext对象的属性
    out.print(pageContext.getAttribute("name") + "<br/>");//获取pageContext对象的属性
    application.setAttribute("name", "application对象");//使用application对象,设置application对象的属性
    out.print(application.getAttribute("name") + "<br/>");//获取application对象的属性
    out.print("Hello Jsp" + "<br/>");//使用out对象
    out.print("服务器调用index.jsp页面时翻译成的类的名字是：" + page.getClass() + " <br/>");//使用page对象
    out.print("处理请求的Servlet的名字是：" + config.getServletName() + "<br/>");//使用config对象
    out.print(response.getContentType() + "<br/>");//使用response对象
    out.print(request.getContextPath() + "<br/>");//使用request对象
%>

<%--jsp声明--%>
<%!
    static {
        System.out.println("loading Servlet!");
    }
    private int globalVar = 0;
    public void jspInit(){
        System.out.println("initializing jsp!");
    }
%>
<%!
    public void jspDestroy(){
        System.out.println("destroying jsp!");
    }
%>

<%
    this.jspInit();
    this.jspDestroy();
%>

<%@include file="file.html"%>
</body>
</html>
