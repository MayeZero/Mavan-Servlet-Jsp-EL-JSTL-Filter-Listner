package com.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        session.setAttribute("date","Hello World");
        String sessionId = session.getId();
//        session的失效时间 优先级（1）
        session.setMaxInactiveInterval(30*60);
        if(session.isNew()){
            resp.getWriter().print("session创建成功,session的id是:" + sessionId);
        }else{
            resp.getWriter().print("服务器已经存在该session了，session的id是：" + sessionId);
        }
    }
}
