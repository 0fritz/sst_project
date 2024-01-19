package ro.uvt.dp.test;

import ro.uvt.dp.Singleton.Logger;

public class testLogger {

    public static void main(String[] args) {
        // Create a Logger instance
        Logger logger = Logger.getInstance();

        // Add some logs
        logger.addLogs("Log entry 1");
        logger.addLogs("Log entry 2");
        logger.addLogs("Log entry 3");   

        // Save the logs to the file
        logger.saveLogs();

        // Assuming the file has been closed after saving logs
        System.out.println("Logs saved successfully!");
    }
}

