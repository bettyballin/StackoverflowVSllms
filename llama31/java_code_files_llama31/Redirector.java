/*
 * Decompiled with CFR 0.152.
 */
import java.net.HttpURLConnection;
import java.net.URL;

public class Redirector {
    public static void main(String[] stringArray) throws Exception {
        URL uRL = new URL("http://example.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setInstanceFollowRedirects(false);
        int n = httpURLConnection.getResponseCode();
        if (n >= 300 && n < 400) {
            String string = httpURLConnection.getHeaderField("Location");
            System.out.println("Redirecting to: " + string);
        }
    }
}
