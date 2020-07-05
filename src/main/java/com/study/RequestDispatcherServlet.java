package com.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDispatcherServlet")
public class RequestDispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("msg","Hello World ...");
//        通过ServletContext实现请求转发
//        this.getServletContext().getRequestDispatcher("/message.jsp").forward(req,resp);
//        通过request实现请求转发
        req.getRequestDispatcher("/message.jsp").forward(req,resp);
    }
}
