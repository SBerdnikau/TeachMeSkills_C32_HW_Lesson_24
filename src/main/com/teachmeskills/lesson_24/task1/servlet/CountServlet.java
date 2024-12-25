package com.teachmeskills.lesson_24.task1.servlet;

import com.teachmeskills.lesson_24.task1.logger.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/count")
public class CountServlet extends HttpServlet {

    @Override
    public void init() {
        Logger.log("CountServlet created");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
        count++;
        session.setAttribute("count", count);

        Logger.log("Подсчет посешений страницы: " + count);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Количество посещений страницы: " + count + "</h1>");
        out.println("<a href='/reset'>Сбросить счётчик посещений</a>");
    }

    @Override
    public void destroy() {
        Logger.log("CountServlet destroyed");
    }
}
