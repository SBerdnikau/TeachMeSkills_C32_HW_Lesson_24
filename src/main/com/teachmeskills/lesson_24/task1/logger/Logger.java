package com.teachmeskills.lesson_24.task1.logger;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static final String LOG_FILE = "D:\\TeachMeSkills_C32_HW\\TeachMeSkills_C32_HW_Lesson_24\\src\\main\\resources\\logs\\logs.txt";

    public static void log(String message) {
        try {
            String dateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
            String infoMessage = "[INFO]\t" + dateTime + "\t\t" + message + "\n";
            Files.write(Paths.get(LOG_FILE), infoMessage.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
