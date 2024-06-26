package com.luvsic.servlet; /**
 * @Author: zyy
 * @Date: 2024/6/18 12:23
 * @Version:
 * @Description:
 */

import com.luvsic.service.DemoService;
import com.luvsic.service.impl.DemoServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainServlet", value = "/test")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 2532630499654907397L;
    private DemoService demoService = new DemoServiceImpl();

    @Override
    public void init() {
        System.out.println("init Part 1 servlet !");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> finds = demoService.findAll();
        response.getWriter().println("P1 servlet startup,find:" + finds);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
