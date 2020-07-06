package com.study;

import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener {
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletRequest has create ...");
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("ServletRequest has destroyed ...");
    }
}
