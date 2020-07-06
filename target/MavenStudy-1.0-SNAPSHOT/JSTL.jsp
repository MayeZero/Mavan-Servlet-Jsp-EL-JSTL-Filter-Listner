<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Nevermore
  Date: 2020/7/6
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
<h4>out标签实例：</h4>
<br>
<!--直接输出了一个字符串。 -->
<c:out value="JSTL的out标签的使用" />
<hr>
<br>
<c:out value="<a href='http://www.baidu.com/'>百度</a>" />
<hr>
<br>
<!--escapeXml="false"表示value值中的html标签不进行转义，而是直接输出 -->
<c:out value="<a href='http://www.baidu.com/'>百度</a>"
       escapeXml="false" />
<hr>
<br>
<!-- 字符串中有转义字符，但在默认情况下没有转换。 -->
<c:out value="&lt未使用字符转义&gt" />
<hr>
<br>
<!-- 使用了转义字符 &lt 和 &gt 分别转换成 < 和 > 符号。 -->
<c:out value="&lt使用字符转义&gt" escapeXml="false"></c:out>
<hr>
<br>
<!-- 设定了默认值，从EL表达式${null}得到空值，所以直接输出设定的默认值。 -->
<c:out value="${null}" default="默认值" />
<hr>
<br>
<!-- 未设定默认值，输出结果为空。 -->
<c:out value="${null}" />

<h4>set标签实例：</h4>
<h5>给指定scope范围赋值：</h5>
<c:set var="name" value="page" scope="page" />
从page域中得到值：${pageScope.name}
<br>
<br>
<c:set var="name" value="request" scope="request" />
从request域中得到值：${requestScope.name}
<br>
<br>
<c:set var="name" value="session" scope="session" />
从session域中得到值：${sessionScope.name}
<br>
<br>
<c:set var="name" scope="application">application</c:set>
使用&lt;c:out&gt;和el，从application域中得到值：
<c:out value="${applicationScope.name}">未得到name的值</c:out>
<br>
<br>
<hr>
<h5>操作JavaBean：</h5>
<jsp:useBean id="emp" class="com.study.Emp" scope="page" />
<!-- 设置JavaBean的属性值 -->
<c:set target="${emp}" property="empno">9527</c:set>
<c:set target="${emp}" property="ename">唐伯虎</c:set>
<c:set target="${emp}" property="job">诗人</c:set>
使用的目标对象为：${person}
<br>
<br> 从Bean中获得的empno值为：
<c:out value="${emp.empno}" />
<br>
<br> 从Bean中获得的ename值为：
<c:out value="${emp.ename}" />
<br>
<br> 从Bean中获得的job值为：
<c:out value="${emp.job}" />
<br>
<br>
<hr>
<h5>操作Map</h5>
<%
    Map<String, String> map = new HashMap<String, String>();
    request.setAttribute("map", map);
%>
<!--将data对象的值存储到map集合中 -->
<c:set property="name" value="g-code" target="${map}" />
从Map中取值：${map.name}
<br>
<hr>

<h4>remove标签实例：</h4>
使用set标签设置变量
<c:set var="name" value="g-code" scope="page" />
<c:set var="age" value="18" scope="session" />
<p>
    name:
    <c:out value="${pageScope.name}" />
</p>
<p>
    age:
    <c:out value="${sessionScope.age}" />
</p>
<hr>
使用remove标签移除age变量
<c:remove var="age" scope="session"/>
<p>
    name:
    <c:out value="${pageScope.name}" />
</p>
<p>
    age:
    <c:out value="${sessionScope.age}" />
</p>
<br>
<hr>

<h4>catch标签实例</h4>
<!--把容易产生异常的代码放在<c:catch></c:catch>中，自定义一个变量errorInfo用于存储异
常信息 -->
<c:catch var="errorInfo">
    <%=1 / 0%>
</c:catch>
<p>用EL表达式输出异常：</p>
<p>
    异常 : ${errorInfo} <br> 异常信息 : ${errorInfo.message}
</p>

<h4>if标签示例：</h4>
<c:set var="name" value="g-code" scope="page" />
<c:if test="${pageScope.name == 'g-code' }" var="result"
      scope="session">
    <c:out value="欢迎您！ " />
</c:if>
${result}
<br>
<hr>

<h4>choose及其嵌套标签示例：</h4>
<hr>
<%--通过set标签设定score的值为85 --%>
<c:set var="score" value="85" />
<c:choose>
    <c:when test="${score >= 90}">
        你的成绩为优秀！
    </c:when>
    <c:when test="${score > 70 && score < 90}">
        您的成绩为良好!
    </c:when>
    <c:when test="${score > 60 && score < 70}">
        您的成绩为及格
    </c:when>
    <c:otherwise>
        对不起，您没有通过考试！
    </c:otherwise>
</c:choose>
<br>
<hr>

<h4>forEach标签实例</h4>
<hr>
<%
    int[] array = { 0, 1, 2, 3, 4 };
    pageContext.setAttribute("array", array);
%>
不指定begin和end的迭代：
<!-- 从集合的第一个元素开始，遍历到最后一个元素 -->
<c:forEach var="num" items="${array}">
    &nbsp;<c:out value="${num}" />
</c:forEach>
<br>
<br> 指定begin和end的迭代：
<!--指定begin的值为1、end的值为4、step的值为2 -->
<!-- 第二个开始，每两个遍历一次，第五个遍历结束 -->
<c:forEach var="num" items="${array}" begin="1" end="4" step="2">
    &nbsp;<c:out value="${num}" />
</c:forEach>
<br>
<br>输出整个迭代的信息：
<br>
<%--指定varStatus的属性名为s，并取出存储的状态信息 --%>
<c:forEach var="num" items="${array}" begin="3" end="4" varStatus="status"
           step="1">
    <c:out value="${num}" />&nbsp;的四种属性：
    index = ${status.index}、count = ${status.count}、first =
    ${status.first}、last = ${status.last}
    <br>
</c:forEach>
<br> Map的迭代：
<%
    Map<String, String> songs = new HashMap<String, String>();
    songs.put("lamar", "Humble");
    songs.put("xxxtentacion", "look at me");
    songs.put("jaychou", "trace");
    pageContext.setAttribute("songs", songs);
%>
<c:forEach var="kv" items="${songs}">
    <c:out value="${kv.key}" /> - <c:out value="${kv.value}" /> &nbsp;
</c:forEach>

<h4>forTokens标签实例：</h4>
<hr>
<c:forTokens var="str" items="be、water、my、friend、!、!、!" delims="、">
    ${str}
</c:forTokens>
<hr>
<c:forTokens items="1*2*3*4*5*6*7" delims="*" begin="1" end="6" step="2"
             var="num" varStatus="status">
    <c:out value="${num}" />&nbsp;的四种属性：
    index = ${status.index}、count = ${status.count}、first =
    ${status.first}、last = ${status.last}
    <br>
</c:forTokens>
<hr>
<%
    String operate = "增加,删除,修改,查询";
    pageContext.setAttribute("operate", operate);
%>
<c:forTokens var="str" items="${operate }" delims="," varStatus="status">
    <input type="checkbox" name="operate" value="${status.index}"> ${str}
</c:forTokens>

<h4>import标签实例：</h4>
<c:import url="http://wwww.baidu.com" charEncoding="utf-8" />
<c:import url="message.jsp" charEncoding="utf-8" />

<h4>import、param标签实例：</h4>
<%--<c:redirect url="http://www.baidu.com">--%>
<%--    <c:param name="username">gcode</c:param>--%>
<%--    <c:param name="password">123456</c:param>--%>
<%--</c:redirect>--%>

<c:if test="${fn:contains('g-code', 'co')}">
    Yes
</c:if>
<%
    pageContext.setAttribute("now", new Date());
%>
<p>
    日期格式化 :
    <fmt:formatDate type="date" value="${now}" />
</p>
</body>
</html>
