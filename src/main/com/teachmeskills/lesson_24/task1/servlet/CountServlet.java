package com.teachmeskills.lesson_24.task1.servlet;

import com.teachmeskills.lesson_24.task1.logger.Logger;
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
        Logger.log("Count servlet is created");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        Logger.log("Calling the counter servlet");
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 0;
        }

        count++;
        session.setAttribute("count", count);

        Logger.log("Counting page visits: " + count);

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
        writer.println("<h1 class='main-heading'>Number of page visits: " + count + "</h1>");
        writer.println("<a href='/reset'>Reset visitor counter</a>");
        writer.println("<footer class='footer'>Copyright © 2024-2025, Developer by Sergey Berdnikov, </footer>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    public void destroy() {
        Logger.log("Count servlet is destroyed");
    }
}
