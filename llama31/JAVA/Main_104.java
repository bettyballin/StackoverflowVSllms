import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpServletResponse;

public class Main_104 {
    public static void main(String[] args) {
        try {
            // Initialize the connection object
            URL url = new URL("http://example.com"); // replace with your URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Initialize the response object
            // Note: HttpServletResponse is typically used in Servlets. 
            // In a console application, you would typically use System.out or a logging framework.
            // For this example, we will use System.out.
            HttpServletResponse response = null; // You can't directly use HttpServletResponse in a console application.

            // Read the contents of the connection
            try (InputStream inputStream = connection.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    // Write the contents to the console
                    System.out.println(line);
                }
            } catch (Exception e) {
                // Handle the exception
                System.out.println("An error occurred: " + e.getMessage());
            }
        } catch (Exception e) {
            // Handle the exception
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}