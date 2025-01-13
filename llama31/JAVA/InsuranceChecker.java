import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsuranceChecker {
    public static void main(String[] args) throws Exception {
        String insuranceNumber = "123456789";
        String apiUrl = "https://example.com/insurance-check";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.getOutputStream().write(("insuranceNumber=" + insuranceNumber).getBytes());

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = reader.readLine();
            System.out.println("Insurance validity: " + result);
        } else {
            System.out.println("Error: " + responseCode);
        }
    }
}