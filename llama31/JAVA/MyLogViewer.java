import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class MyLogViewer {
    private static final Logger logger = Logger.getLogger(MyLogViewer.class.getName());

    // Create a simple log viewer that filters out sensitive information
    public String getLogOutput() {
        StringBuilder logOutput = new StringBuilder();

        // Read the log file and filter out sensitive information
        try (FileInputStream fis = new FileInputStream("/path/to/glassfish/logs/server.log");
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Simple filtering example: remove lines containing "password"
                if (!line.contains("password")) {
                    logOutput.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            logger.severe("Error reading log file: " + e.getMessage());
        }

        return logOutput.toString();
    }

    public static void main(String[] args) {
        MyLogViewer logViewer = new MyLogViewer();
        System.out.println(logViewer.getLogOutput());
    }
}