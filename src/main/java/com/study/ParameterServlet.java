package com.study;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class ParameterServlet extends HttpServlet {
//    getParameter and getParameterValues
//http://localhost:8080/ServletTest/ParameterServlet?userid=15&username=zz&userpass=123456&sex=%E7%94%B7&dept=god&inst=basketball,sing,rap&note=%E6%B3%A8%E6%84%8F%E6%80%81%E5%BA%A6!&hiddenField=money
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
// 客户端是以UTF-8编码提交表单数据的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
        request.setCharacterEncoding("UTF-8");
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        String sex = request.getParameter("sex");
        String dept = request.getParameter("dept");
        String[] insts = request.getParameterValues("inst");
        String instStr = Arrays.toString(insts);
        String note = request.getParameter("note");
        String hiddenField = request.getParameter("hiddenField");
        String htmlStr = "<table>" + "<tr><td>填写的编号：</td><td>{0}</td></tr>" + "<tr><td>填写的用户名：</td><td>{1}</td></tr>"
            + "<tr><td>填写的密码：</td><td>{2}</td></tr>" + "<tr><td>选中的性别：</td><td>{3}</td></tr>"
            + "<tr><td>选中的部门：</td><td>{4}</td></tr>" + "<tr><td>选中的兴趣：</td><td>{5}</td></tr>"
            + "<tr><td>填写的说明：</td><td>{6}</td></tr>" + "<tr><td>隐藏域的内容：</td><td>{7}</td></tr>" + "</table>";
        htmlStr = MessageFormat.format(htmlStr, userid, username, userpass, sex,
                dept, instStr, note, hiddenField);
// 设置服务器端以UTF-8编码输出数据到客户端
        response.setCharacterEncoding("UTF-8");
        // 设置客户端浏览器以UTF-8编码解析数据
        response.setContentType("text/html;charset=UTF-8");
// 输出htmlStr里面的内容到客户端浏览器显示
        response.getWriter().write(htmlStr);
    }

    // http://localhost:8080/ServletTest/ParameterServlet?username=zz&password=123456
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //    getParameterMap
//request对象封装的参数是以Map的形式存储的
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> paramMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String paramName = entry.getKey();
            String paramValue = "";
            String[] paramValueArr = entry.getValue();
            for (int i = 0; paramValueArr != null && i < paramValueArr.length; i++)
            {
                if (i == paramValueArr.length - 1) {
                    paramValue += paramValueArr[i];
                } else {
                    paramValue += paramValueArr[i] + ",";
                }
            }
            System.out.println(MessageFormat.format("{0}={1}", paramName,
                    paramValue));
        }

//        getPatameterNames
//        request.setCharacterEncoding("UTF-8");
//// Enumeration接口中定义了一些方法，通过这些方法可以枚举（一次获得一个）对象集合中的元素
//        Enumeration<String> paramNames = request.getParameterNames();//获取所有的参数名
//        while (paramNames.hasMoreElements()) {
//        String name = paramNames.nextElement();//得到参数名
//        String value = request.getParameter(name);//通过参数名获取对应的值
//        System.out.println(MessageFormat.format("{0}={1}", name,value));
//        }
    }
}
