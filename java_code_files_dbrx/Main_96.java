import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String contentType = null;
        try {
            URL url = new URL("https://your_url_here");
            try (InputStream is = url.openStream()) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                    if (!reader.ready()) {
                        throw new IOException();
                    }

                    // First 15 chars are enough, because Content-Type: text/html; charset=UTF8 is used normally
                    contentType = reader.readLine().substring(0, 15);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't make HTTP request", e);
        }
        System.out.println(contentType); // "text/html; charset" or another value depends on the content-type of your URL
    }
}