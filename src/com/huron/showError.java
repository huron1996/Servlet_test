package com.huron;

//将407错误码返回给客户端，告知客户端必须使用代理服务器进行验证

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "showError",urlPatterns = "/ShowError")
public class showError extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        //设置错误码及原因
        response.sendError(407,"Need authentication!");
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
