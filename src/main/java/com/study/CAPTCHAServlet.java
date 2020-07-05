package com.study;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class CAPTCHAServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       设置响应头控制浏览器以图片方式打开
        resp.setHeader("Content-Type","image/jpeg");
//        设置响应头不缓存图片数据
        resp.setDateHeader("expries",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        OutputStream outputStream = resp.getOutputStream();
        ImageIO.write(ImageUtil.createImage(req.getSession(), 5),"jpg",outputStream);
    }
}
