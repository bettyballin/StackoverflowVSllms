// Note: Requires Apache HttpClient library (e.g., httpclient-4.5.13.jar)
// To compile: javac -cp .;path\to\httpclient-4.5.13.jar Main.java
// To run: java -cp .;path\to\httpclient-4.5.13.jar Main

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpGet;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "https://your-api-url/endpoint"; // Replace with appropriate values
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        request.setHeader("Content-Type", "application/json"); // If JSON is used
        CloseableHttpResponse response = httpclient.execute(request);
        // Handle your response (e.g., convert to Java object)
        response.close();
        httpclient.close();
    }
}