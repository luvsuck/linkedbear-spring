package com.luvsic.ejb;


import jakarta.ejb.EJB;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "EjbServlet", value = "/test")
public class EjbServlet extends HttpServlet {
    private static final long serialVersionUID = -314889449400387168L;
    private String message;

    /**
     * 在tomcat服务器下拿不到
     * 得用wildfly、glassFish等容器
     */
    @EJB
    private GreetingBean greetingBean;

    public void init() {
        System.out.println("init ejb servlet !");
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        greetingBean.greet();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}