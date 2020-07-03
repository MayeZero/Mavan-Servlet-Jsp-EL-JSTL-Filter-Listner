package com.study;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class HeadInfoServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();
        Enumeration<String> reqHeadInfos = request.getHeaderNames();
        out.write("获取到的客户端所有请求头信息如下：");
        out.write("</hr>");
        while(reqHeadInfos.hasMoreElements()){
            String headName = (String) reqHeadInfos.nextElement();
            String headValue = request.getHeader(headName);
            out.write(headName + ":" + headValue);
            out.write("</br>");
        }
        out.write("</br>");
        out.write("获取到的客户端Accept-Encoding请求头的值：");
        out.write("</hr>");
        String value = request.getHeader("Accept-Encoding");
        out.write(value);
        Enumeration<String> e = request.getHeaders("Accept-Encoding");
        while(e.hasMoreElements()){
            String string = (String)e.nextElement();
            System.out.println(string);
        }
    }
}
