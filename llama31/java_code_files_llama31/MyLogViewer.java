/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class MyLogViewer {
    private static final Logger logger = Logger.getLogger(MyLogViewer.class.getName());

    public String getLogOutput() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream("/path/to/glassfish/logs/server.log");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));){
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                if (string.contains("password")) continue;
                stringBuilder.append(string).append("\n");
            }
        }
        catch (IOException iOException) {
            logger.severe("Error reading log file: " + iOException.getMessage());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
        MyLogViewer myLogViewer = new MyLogViewer();
        System.out.println(myLogViewer.getLogOutput());
    }
}
