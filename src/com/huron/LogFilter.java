package com.huron;

//过滤器

import javax.servlet.*;
import java.io.IOException;
import java.util.*;

public class LogFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获得初始化参数
        String site = filterConfig.getInitParameter("Site");

        System.out.println("网站名称：" + site);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("站点网址：www.huron.com");

        //将请求传回过滤链
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
