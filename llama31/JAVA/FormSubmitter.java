import java.net.*;
import java.io.*;

public class FormSubmitter {
  public static void main(String[] args) throws Exception {
    URL submitUrl = new URL("https://example.com/form-action");
    URL refererUrl = new URL("https://example.com/referring-page");

    // Set up the submit variables
    String firstName = "John";
    String lastName = "Doe";

    // Create a URL-encoded string of the submit variables
    String submitVarsUrlencoded = "firstName=" + URLEncoder.encode(firstName, "UTF-8") +
                                  "&lastName=" + URLEncoder.encode(lastName, "UTF-8");

    // Set up the request
    HttpURLConnection connection = (HttpURLConnection) submitUrl.openConnection();
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Referer", refererUrl.toString());
    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    connection.setRequestProperty("Content-Length", String.valueOf(submitVarsUrlencoded.length()));

    // Send the request
    connection.setDoOutput(true);
    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
    writer.write(submitVarsUrlencoded);
    writer.flush();

    // Read the response
    int responseCode = connection.getResponseCode();
    if (responseCode == 200) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } else {
      System.out.println("Error: " + responseCode);
    }
  }
}