import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyService_2 {
    public void sendRequest(String jsonData) {
        try {
            URL url = new URL("https://yourserver.com/api/endpoint");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Write request body
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int status = conn.getResponseCode();
            if (status >= 200 && status < 300) {
                // Read response
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    StringBuilder responseData = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        responseData.append(responseLine.trim());
                    }
                    // Handle response data
                }
            } else {
                // Handle error
                System.out.println("Error: " + status);
            }

        } catch (Exception e) {
            System.out.println("Failed to send request: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage
        MyService_2 service = new MyService_2();
        String jsonData = "{\"key\":\"value\"}";
        service.sendRequest(jsonData);
    }
}