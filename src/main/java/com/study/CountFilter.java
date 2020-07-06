package com.study;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "TestFilter", urlPatterns = "/*",initParams = {@WebInitParam(name="count",value = "1000")})
public class CountFilter implements Filter {
    private Integer count;
    public void init(FilterConfig fConfig) throws ServletException {
        count = Integer.parseInt(fConfig.getInitParameter("count"));
    }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        count++;
        System.out.println("访问量：" + count);
        request.getServletContext().setAttribute("count", count);
        chain.doFilter(request, response);
    }
    public void destroy() {
    }
}
