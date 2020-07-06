package com.study;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext has create ...");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext has destroyed ...");
    }
}
