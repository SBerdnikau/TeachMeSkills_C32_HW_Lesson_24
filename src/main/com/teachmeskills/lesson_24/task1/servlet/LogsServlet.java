package com.teachmeskills.lesson_24.task1.servlet;

import com.teachmeskills.lesson_24.task1.logger.Logger;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/logs")
public class LogsServlet extends HttpServlet {

    @Override
    public void init()  {
        Logger.log("Log servlet is created");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
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
        writer.println("<h1 class='main-heading'>Logs</h1>");
        writer.println("<ul class='log-group'>");
        Logger.log("Calling the log servlet");
        final String path = "D:\\TeachMeSkills_C32_HW\\TeachMeSkills_C32_HW_Lesson_24\\src\\main\\resources\\logs\\logs.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                writer.println("<li>" + line + "</li>");
            }
        } catch (IOException e) {
            writer.println("Exception reading log file: " + e.getMessage());
        }
        writer.println("</ul>");
        writer.println("<footer class='footer'>Copyright © 2024-2025, Developer by Sergey Berdnikov, </footer>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    public void destroy() {
        Logger.log("Log servlet is destroyed");
    }

}