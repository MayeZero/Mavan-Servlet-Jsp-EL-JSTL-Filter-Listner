<%@ page import="com.study.Emp" %>
<%@ page import="com.study.Department" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Nevermore
  Date: 2020/7/6
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/ELFunction" prefix="fn"%>
<html>
<head>
    <title>EL</title>
</head>
<body>
EL 表达式进行算数运算：${1 + 1}、${1 - 1}、${2 * 2}、${1 / 2}、${1 mod 2}、${(1
        + 2) * 3}
<hr>
<br>
EL 表达式进行关系运算：${emp eq null}、${1 != 2}、${2 ge 3}、${3 lt 3}、
<hr>
<br>
EL 表达式进行逻辑运算:${true || false}、${true && false}、${!(1 == 1)}、
${empty(null)}
<hr>
<br>
EL 表达式中使用三元表达式：${1==1 ? 'Yes' : 'No'}
<br />

<%
    request.setAttribute("code","123456");
%>
使用EL表达式获取数据：${code}
<hr>
<br>
<%
    Emp emp = new Emp();
    emp.setEmpno(666);
    emp.setEname("G-code");
    request.setAttribute("emp", emp);
%>
使用 EL 表达式可以获取对象的属性：${emp.empno}、${emp.ename}
<hr>
<br>
<%
    Department department = new Department();
    department.setDeptno(10);
    department.setDname("教学部");
    emp.setDepartment(department);
    request.setAttribute("emp", emp);
%>
使用 EL 表达式可以获取对象中的对象属性：${emp.department.deptno}、
${emp.department.dname}
<hr>
<br>
<%
    Emp emp1 = new Emp();
    emp1.setEmpno(1);
    emp1.setEname("张三");
    Emp emp2 = new Emp();
    emp2.setEmpno(2);
    emp2.setEname("李四");
    List<Emp> list = new ArrayList<Emp>();
    list.add(emp1);
    list.add(emp2);
    request.setAttribute("list", list);
%>
使用 EL 表达式获取list集合中指定位置的数据：${list[0].empno}、${list[1].ename}
<hr>
<br>
<%
    Map<String, String> map = new LinkedHashMap<String, String>();
    map.put("a", "aaaa");
    map.put("b", "bbbb");
    map.put("c", "cccc");
    request.setAttribute("map", map);
%>
使用 EL 表达式获取map集合的数据：${map.a} ${map["c"]}
<hr>
<br>

获取 Jsp 页面中的pageContext对象:${pageContext}
<hr>
<br>
<%
    pageContext.setAttribute("name", "gcode1"); //map
%>
从page域(pageScope)中查找数据：${pageScope.name}
<hr>
<br>
<%
    request.setAttribute("name", "g-code2"); //map
%>
从request域(requestScope)中获取数据：${requestScope.name}
<hr>
<br>
<%
    session.setAttribute("name", "g-code3"); //map
%>
从session域(sessionScope)中获取数据：${sessionScope.name}
<hr>
<br>
<%
    application.setAttribute("name", "g-code4"); //map
%>
从application域(applicationScope)中获取数据：${applicationScope.name}
<hr>
<br>
<!--
param和paramValues对象用来访问参数值。
通过使用request.getParameter方法和request.getParameterValues方法。
param对象返回单一的字符串，而paramValues对象则返回一个字符串数组。
-->
<!-- http://localhost:8080/ServletTest/EL.jsp?name=g-code -->
从request请求中获取参数：${param.name}
<hr>
<br>
<!-- http://localhost:8080/ServletTest/EL.jsp?hobby=java&hobby=python -->
从request请求中获取参数：${paramValues.hobby[0]}、${paramValues.hobby[1]}
<hr>
<br> 从header请求头中获取参数：${header.Host}、${header["Accept-Language"]}
<hr>
<br> 从header请求头中获取参数：${headerValues.Accept[0]}、
${headerValues["Accept-Encoding"][0]}
<hr>
<br>从cookie对象中取值：${cookie.JSESSIONID.value}
<hr>
<br> initParam对象获取在web.xml文件中配置的初始化参数：${initParam.url}
<hr>
<br>
    ${fn:say("g-code")}
</body>
</html>
