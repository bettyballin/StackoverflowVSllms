/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpPostSender {
    public static void main(String[] stringArray) {
        try {
            URL uRL = new URL("http://example.com");
            byte[] byArray = "Hello, World!".getBytes();
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(byArray);
            outputStream.close();
            System.out.println("Data sent successfully");
        }
        catch (MalformedURLException malformedURLException) {
            System.out.println("Invalid URL: " + malformedURLException.getMessage());
        }
        catch (IOException iOException) {
            System.out.println("Error sending data: " + iOException.getMessage());
        }
    }
}
