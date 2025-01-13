/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main_515 {
    public static void main(String[] stringArray) {
        try {
            URL uRL = new URL("http://example.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(30000);
            System.out.println("Response Code: " + httpURLConnection.getResponseCode());
        }
        catch (MalformedURLException malformedURLException) {
            System.out.println("Invalid URL: " + malformedURLException.getMessage());
        }
        catch (IOException iOException) {
            System.out.println("Failed to establish connection: " + iOException.getMessage());
        }
    }
}
