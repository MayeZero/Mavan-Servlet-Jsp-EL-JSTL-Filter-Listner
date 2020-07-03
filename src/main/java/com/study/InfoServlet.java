package com.study;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InfoServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String requestUrl = request.getRequestURL().toString();
        String requestUri = request.getRequestURI();
        String queryString = request.getQueryString();
        String remoteAddr = request.getRemoteAddr();
        int remotePort = request.getRemotePort();
        String method = request.getMethod();
        String localAddr = request.getLocalAddr();
        String localName = request.getLocalName();
        response.setCharacterEncoding("UTF-8");

        response.setHeader("content-type", "text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();
        out.write("获取到的客户机信息如下：");
        out.write("</hr>");
        out.write("请求的URL地址：" + requestUrl + "</br>");
        out.write("请求的资源：" + requestUri + "</br>");
        out.write("请求的URL地址中附带的参数：" + queryString + "</br>");
        out.write("来访者的IP地址：" + remoteAddr + "</br>");
        out.write("使用的端口号：" + remotePort + "</br>");
        out.write("使用的http方式：" + method + "</br>");
        out.write("localAddr：" + localAddr + "</br>");
        out.write("localName：" + localName + "</br>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doGet(request,response);
    }
}
