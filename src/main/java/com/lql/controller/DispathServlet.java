package com.lql.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lql
 * @date 2021/6/4 10:27
 * Description：
 */
@WebServlet("/")
public class DispathServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String servletPath = req.getServletPath();
        System.out.println("请求路径 ：" + servletPath);

        String method = req.getMethod();
        System.out.println("请求方法： "+ method);
    }
}
