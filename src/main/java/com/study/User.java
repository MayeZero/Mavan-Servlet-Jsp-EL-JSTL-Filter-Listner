package com.study;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    private String username;
    public User() {
    }
    public User(String username) {
        super();
        this.username = username;
    }

    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(event.getName() + " bound to session");
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println(event.getName() + " unbound to session");
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        return "User [username=" + username + "]";
    }
}