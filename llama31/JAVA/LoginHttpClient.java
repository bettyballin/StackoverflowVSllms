import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class LoginHttpClient {

    private void Login() {
        HttpClient httpClient = new DefaultHttpClient();
        try {
            String url = "http://192.168.1.5:8000/Login/Login?username=test&password=test";

            HttpGet method = new HttpGet(new URI(url));
            HttpResponse response = httpClient.execute(method);
            if (response != null) {
                System.out.println("login: received " + getResponse(response.getEntity()));
            } else {
                System.out.println("login: got a null response");
            }
        } catch (IOException e) {
            System.err.println("error: " + e.getMessage());
        } catch (URISyntaxException e) {
            System.err.println("error: " + e.getMessage());
        }
    }

    private String getResponse(HttpEntity entity) throws IOException {
        // Implementation of getResponse is missing, you need to implement it
        // For example:
        java.io.InputStream in = entity.getContent();
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(in));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) {
        LoginHttpClient client = new LoginHttpClient();
        client.Login();
    }
}