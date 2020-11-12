package com.huron;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//测试Cookie实例
@WebServlet(name = "CookieTest",urlPatterns = "/CookieTest")
//@WebServlet("/Servlet_test3_war_exploded/CookieTest")

public class SetCookie extends HttpServlet{
    private static final long serialVerisonUID = 1L;

    public SetCookie() {
        super();
    }


    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        //为名字和姓氏创建Cookie
        Cookie name = new Cookie("name",URLEncoder.encode(request.getParameter("name"),"UTF-8"));
        Cookie url = new Cookie("url",request.getParameter("url"));

        //为两个Cookie设置24小时的过期时间
        name.setMaxAge(60*60*24);
        url.setMaxAge(60*60*24);

        //在响应头中添加两个Cookie
        response.addCookie(name);
        response.addCookie(url);

        //设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();
        String title = "设置Cookie实例";
        String docType = "<!DOCTYPE html>\n";
        printWriter.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名：</b>："
                + request.getParameter("name") + "\n</li>" +
                "  <li><b>站点 URL：</b>："
                + request.getParameter("url") + "\n</li>" +
                "</ul>\n" +
                "</body></html>");
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request,response);
    }


}


























