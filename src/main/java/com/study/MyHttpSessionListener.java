package com.study;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(sdf.format(new Date()) + " session has create, id is " + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(sdf.format(new Date()) + " session has destroyed ... ");
    }
}
