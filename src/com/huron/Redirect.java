package com.huron;

//重定向

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "redirect",urlPatterns = "/Redirect")
public class Redirect extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        //设置redirect
        String url = "http://localhost:8080/Servlet_test3_war_exploded/Refresh";
        response.sendRedirect(url);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
