package com.huron;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorld",urlPatterns = "/hello")
public class HelloWorld extends HttpServlet{
    private String message;

    public void init() throws ServletException{
        message = "hello world!";
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }
}
