import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

public class MyProgram {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://yourserver/resource"); // Replace with your address

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("POST"); // set request method to POST or GET as needed
            connection.setDoInput(true);         // Use for POST Method
            connection.setDoOutput(true);        // Set this option to true when sending data on the output stream

            try (OutputStream os = connection.getOutputStream()) { // get an OutputStream to write data from (send a POST)
                byte[] input = "your message".getBytes("UTF-8");     // For example your string is converted into bytes here
                os.write(input, 0, input.length);                   // writes the HTTP request body to the output stream of this connection
            }

            // Send request
            if (connection.getResponseCode() != 200) { // If response code isn't HTTP_OK status, throw exception
                throw new RuntimeException("Request Failed : HTTP Error Code: " + connection.getResponseCode());
            } else {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line, resp = null;                   // Prepare some strings
                    while ((line = br.readLine()) != null) {    // Read the response and prepare it as a String in resp variable
                        if (resp == null) {
                            resp = line;
                        } else {
                            resp += "\n" + line;                // If it's not first line append with newline character.
                        }
                    }
                    System.out.println("Result from post is " + resp); // Print result
                } // BufferedReader 'br' will be closed automatically
            }
        } catch (MalformedURLException e) {
            System.out.println("Couldn't establish connection: malformed URL");
        } catch (UnsupportedEncodingException ue) {
            System.err.println(ue);
        } catch (IOException ioe) {
            System.err.println(ioe);
        } finally {
            // Close your streams and resources here - not shown in this example
        }
    }
}