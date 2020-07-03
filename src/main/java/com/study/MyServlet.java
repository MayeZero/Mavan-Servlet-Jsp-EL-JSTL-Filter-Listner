package com.study;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    private ServletConfig config;
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        System.out.println("MyServlet start init .....");
        this.config = config;
    }

    @Override
    public void destroy(){
        System.out.println("MyServlet was destroyed ...");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("<table>");
        out.write("<tr>");
        out.write("<td>用户名：</td>");
        out.write("<td>" + this.config.getInitParameter("username") + "</td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("<td>密码：</td>");
        out.write("<td>" + this.config.getInitParameter("password") + "</td>");
        out.write("</tr>");
        out.write("</table>");
        out.close();
    }
}

