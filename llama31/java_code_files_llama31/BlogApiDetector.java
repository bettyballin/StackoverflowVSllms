/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class BlogApiDetector {
    public static void main(String[] stringArray) throws IOException {
        String string = "http://example.com";
        String string2 = BlogApiDetector.detectBlogApi(string);
        System.out.println("Blog type: " + string2);
    }

    public static String detectBlogApi(String string) throws IOException {
        URL uRL = new URL(string);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("HEAD");
        httpURLConnection.connect();
        if (string.contains("blogger.com")) {
            return "Blogger";
        }
        if (string.contains("wordpress.com")) {
            return "WordPress";
        }
        String[] stringArray = httpURLConnection.getHeaderFields().keySet().toArray(new String[0]);
        for (String string2 : stringArray) {
            if (!string2.equals("X-Powered-By") || !httpURLConnection.getHeaderField(string2).contains("WordPress")) continue;
            return "WordPress";
        }
        String string3 = new Scanner(uRL.openStream()).useDelimiter("\\Z").next();
        if (string3.contains("<link rel=\"alternate\" type=\"application/rss+xml\"")) {
            return "RSS";
        }
        return "Unknown";
    }
}
