package com.teachmeskills.lesson_24.task1.servlet;

import com.teachmeskills.lesson_24.task1.logger.Logger;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/settings")
public class SettingsServlet extends HttpServlet {

    @Override
    public void init()  {
        Logger.log("Settings Servlet created");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        Logger.log("Вывод параметров приложения");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Настройки приложения</h1>");
        out.println("<p>Имя приложения: " + getServletContext().getInitParameter("appName") + "</p>");
        out.println("<p>Версия приложения: " + getServletContext().getInitParameter("appVersion") + "</p>");
        out.println("<p>Имя разработчика: " + getServletContext().getInitParameter("developerName") + "</p>");
        out.println("<p>Email поддержки: " + getServletContext().getInitParameter("supportEmail") + "</p>");
    }

    @Override
    public void destroy() {
        Logger.log("Settings Servlet destroyed");
    }
}
