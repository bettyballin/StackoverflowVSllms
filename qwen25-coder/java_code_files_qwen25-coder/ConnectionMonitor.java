import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

public class ConnectionMonitor {
    private static final String CHECK_URL = "http://www.google.com"; // You can use any reliable server URL
    private static final int TIMEOUT = 5000; // Timeout in milliseconds

    public static void main(String[] args) throws InterruptedException {
        while (true) { // Infinite loop to continuously monitor the connection
            if (!isInternetAvailable()) {
                System.out.println("Internet connection lost at: " + LocalDateTime.now());
            } else {
                System.out.println("Connection is active.");
            }
            
            Thread.sleep(10000); // Check every 10 seconds, adjust as needed
        }
    }

    private static boolean isInternetAvailable() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(CHECK_URL).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(TIMEOUT);
            connection.connect();
            connection.disconnect();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}