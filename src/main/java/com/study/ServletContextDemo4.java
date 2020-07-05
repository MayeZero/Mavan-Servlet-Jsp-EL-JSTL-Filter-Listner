package com.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

@WebServlet("/ServletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream in = this.getServletContext().getResourceAsStream("WEB-INF/classes/db.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driverClassName");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        resp.setHeader("content-type","text/html;charset=UTF-8");
        resp.getWriter().write("读取src目录下的db.properties配置文件：<br>");
        resp.getWriter().write(
                MessageFormat.format("driver={0}<br>url={1}<br>username={2}<br>password={3}",
                        driver,url,username,password));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
