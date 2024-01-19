package ro.uvt.dp.Singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger single_instance = null;
    private PrintWriter fileWriter;
    private List<String> logs;

    private Logger() {
        logs = new ArrayList<>();
        try {
            fileWriter = new PrintWriter(new FileWriter("server.log"));
        } catch (IOException e) {
            e.printStackTrace();
            // Consider logging the exception or handling it appropriately
        }
    }
    

    public static Logger getInstance() {
        if (single_instance == null) {
            synchronized (Logger.class) {
                if (single_instance == null) {
                    single_instance = new Logger();
                }
            }
        }
        return single_instance;
    }
    

    public void addLogs(String x) {
        logs.add(x);
    }

    public void saveLogs() {
        for (String log : logs) {
            fileWriter.println(log);
            fileWriter.flush();
        }
        fileWriter.close(); // Add this line to close the file
    }
    
}
