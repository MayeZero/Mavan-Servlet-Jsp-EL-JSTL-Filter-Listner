package com.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestServlet", urlPatterns = "/TestServlet", loadOnStartup = 1,
initParams = {@WebInitParam(name = "icon", value = "xxx") })
public class TestServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        System.out.println("TestServlet start init .....");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("The Icon is : " + getInitParameter("icon"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}