package com.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            out.write("您上次访问的时间是：");
            for(int i = 0; i < cookies.length; i++){
                Cookie cookie = cookies[i];
//                Cookie读取中文
//                URLDecoder.decode(cookies[i].getValue(),"UTF-8");
                if(cookie.getName().equals("lastAccessTime")){
                    Long lastAccessTime = Long.parseLong(cookie.getValue()) ;
                    Date date = new Date(lastAccessTime);
                    out.write(date.toString());
                }
            }
        }else{
            out.write("这是你第一次访问本站!");
        }
        Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
//        Cookie存取中文
//        Cookie cookie = new Cookie("userName", URLEncoder.encode("哈哈","UTF-8"));
        cookie.setMaxAge(24*60*60);
//        删除cookie
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }
}
