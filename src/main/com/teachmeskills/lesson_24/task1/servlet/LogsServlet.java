package com.teachmeskills.lesson_24.task1.servlet;

import com.teachmeskills.lesson_24.task1.logger.Logger;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logs")
public class LogsServlet extends HttpServlet {

    @Override
    public void init()  {
        Logger.log("Сервлет LogServlet инициализирован");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\TeachMeSkills_C32_HW\\TeachMeSkills_C32_HW_Lesson_24\\src\\main\\resources\\logs\\logs.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException e) {
            out.println("Ошибка при чтении файла логов: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        Logger.log("Сервлет LogServlet уничтожен");
    }

}
