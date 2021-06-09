package com.lql;

import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lql
 * @date 2021/6/3 12:21
 * Description：
 */
@WebServlet("/hello")
@Log4j
public class HelloServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我执行了service。doget");
        doGet(req,resp);
    }

    @Override
    public void destroy() {

        System.out.println("爸爸被销毁了....");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("爸爸被创建了....");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "我的简易框架";
        req.setAttribute("name",name);
        req.getRequestDispatcher("/WEB_INF/jsp/hello.jsp").forward(req,resp);

        log.debug("name is " + name);

    }

}
