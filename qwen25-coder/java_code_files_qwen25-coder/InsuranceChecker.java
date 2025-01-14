import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class InsuranceChecker {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://insurancewebsite.com/checkInsurance"); // Replace with the actual URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method and headers
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Send insurance number as a parameter
            String postData = "insuranceNumber=1234567890"; // Replace with actual insurance number variable

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = postData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Get the response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }

                // Response contains HTML with results, you need to parse it
                System.out.println("Response: " + response.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}