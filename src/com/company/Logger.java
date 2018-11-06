package com.company;

import java.io.*;

public class Logger {
    private static Logger instance;

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public static void addLog(String log) {
        BufferedWriter z;
        try {
            z = new BufferedWriter(new FileWriter(new File("C:/Users/Tom/Desktop/Laba2/logs.txt"),true));

            z.newLine();
            z.write(log + "\n");

            z.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
