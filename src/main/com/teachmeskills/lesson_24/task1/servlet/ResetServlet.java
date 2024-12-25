package com.teachmeskills.lesson_24.task1.servlet;

import com.teachmeskills.lesson_24.task1.logger.Logger;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/reset")
public class ResetServlet extends HttpServlet {

    @Override
    public void init()  {
        Logger.log("ResetServlet created");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        Logger.log("Сброс установок сессии");
        HttpSession session = request.getSession();
        session.invalidate();

        response.setContentType("text/html");
        response.getWriter().println("<h1>Счетчик посещений страницы сброшен.</h1>");
        response.getWriter().println("<a href='/count'><p>Перейти на страницу посещений</p></a>");
    }

    @Override
    public void destroy() {
        Logger.log("ResetServlet destroyed");
    }
}
