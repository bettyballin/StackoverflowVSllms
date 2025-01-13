/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiHttpClient {
    public static void main(String[] stringArray) {
        try {
            URL uRL = new URL("https://example.com/api/resource");
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            int n = httpURLConnection.getResponseCode();
            System.out.println("Response Code: " + n);
        }
        catch (MalformedURLException malformedURLException) {
            System.out.println("Invalid URL");
        }
        catch (IOException iOException) {
            System.out.println("Error making HTTP request");
        }
    }
}
