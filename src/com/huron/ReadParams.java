package com.huron;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReadParams",urlPatterns = "/ReadParams")
public class ReadParams extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public ReadParams() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UFT-8");

        PrintWriter out = response.getWriter();

        String title = "读取所有表单的数据";

        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "<th>参数名称</th><th>参数值</th>\n" +
                "</tr>\n");

        Enumeration paraNames = request.getParameterNames();

        while (paraNames.hasMoreElements()) {
            String paramName = (String) paraNames.nextElement();
            out.print("<tr><td>" + paramName + "</td>\n");
            String[] paramValues = request.getParameterValues(paramName);

            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0)
                    out.println("<td><i>没有值</i></td>");
                else
                    out.println("<td>" + paramValue + "</td>");
            } else {
                out.println("<td><ul>");
                for (int i = 0; i < paramValues.length; i++) {
                    out.println("<li>" + paramValues[i]);
                }
                out.println("</ul></td>");
            }
            out.print("</tr>");
        }
        out.println("\n</table>\n</body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}






















