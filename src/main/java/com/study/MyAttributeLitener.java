package com.study;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.text.MessageFormat;

@WebListener
public class MyAttributeLitener
        implements ServletContextAttributeListener,
        HttpSessionAttributeListener, ServletRequestAttributeListener {
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println(MessageFormat.format("ServletRequest add Attributename : {0}，value : {1}", event.getName(),
                event.getValue()));
    }

    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println(MessageFormat.format("HttpSession add Attribute name: {0}，value : {1}", event.getName(),
        event.getValue()));
    }

    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println(MessageFormat.format("ServletContext add Attribute name : {0}，value : {1}", event.getName(),
        event.getValue()));
    }

    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println(MessageFormat.format("ServletRequest replace Attribute name : {0}，value : {1}",
        event.getName(), event.getValue()));
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println(MessageFormat.format("HttpSession replace Attribute name : {0}，value : {1}", event.getName(),
        event.getValue()));
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println(MessageFormat.format("ServletContext replace Attribute name : {0}，value : {1}",
        event.getName(), event.getValue()));
    }

    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println(MessageFormat.format("ServletRequest remove Attributename : {0}，value : {1}",
                event.getName(), event.getValue()));
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println(MessageFormat.format("HttpSession remove Attribute name : {0}，value : {1}", event.getName(),
        event.getValue()));
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println(MessageFormat.format("ServletRequest remove Attribute name : {0}，value : {1}",
        event.getName(), event.getValue()));
    }
}