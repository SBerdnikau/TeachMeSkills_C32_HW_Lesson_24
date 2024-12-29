package com.teachmeskills.lesson_24.task1.servlet;

import com.teachmeskills.lesson_24.task1.logger.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    public void init()  {
        Logger.log("Main servlet is created");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.log("Calling the main servlet");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        Logger.log("Main servlet is destroyed");
    }
}
