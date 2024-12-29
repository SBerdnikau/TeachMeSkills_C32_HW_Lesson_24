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
        Logger.log("Settings servlet is created");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        Logger.log("Calling the settings servlet");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Settings</title>");
        writer.println("<link rel='stylesheet' href='style.css'>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<nav class='navbar'>");
        writer.println("<ul class='link-group'>");
        writer.println("<li class='link'><a href='index.jsp'>Home</a></li>");
        writer.println("<li class='link'><a href='tasks.jsp'>tasks</a></li>");
        writer.println("</ul>");
        writer.println("</nav>");
        writer.println("<h1 class='main-heading'>Application Settings</h1>");
        writer.println("<ul class='settings-group'>");
        writer.println("<li>Application name: " + getServletContext().getInitParameter("appName") + "</li>");
        writer.println("<li>Application version: " + getServletContext().getInitParameter("appVersion") + "</li>");
        writer.println("<li>Developer name: " + getServletContext().getInitParameter("developerName") + "</li>");
        writer.println("<li>Support email: " + getServletContext().getInitParameter("supportEmail") + "</li>");
        writer.println("</ul>");
        writer.println("<footer class='footer'>Copyright © 2024-2025, Developer by Sergey Berdnikov, </footer>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    public void destroy() {
        Logger.log("Settings servlet is destroyed");
    }
}
