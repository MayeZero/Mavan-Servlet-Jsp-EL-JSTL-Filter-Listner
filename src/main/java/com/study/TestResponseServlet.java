package com.study;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class TestResponseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data="中国";
////得到OutputStream
//        OutputStream outputStream = resp.getOutputStream();
////设置头部信息让浏览器以UTF-8显示
//        resp.setHeader("content-type", "text/html;charset=UTF-8");
////字符转换了字节数组，以UTF-8编码转换
//        byte[] array = data.getBytes("UTF-8");
////outputStream流输出字节数组
//        outputStream.write(array);
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type","text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(data);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
