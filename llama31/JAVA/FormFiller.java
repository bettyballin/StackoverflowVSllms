import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FormFiller {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com/form");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        // Set form data
        String formData = "field1=value1&field2=value2";

        // Send request
        try (DataOutputStream out = new DataOutputStream(connection.getOutputStream())) {
            out.writeBytes(formData);
        }

        // Read response
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        }
    }
}