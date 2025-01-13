/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUpdateChecker {
    public static void main(String[] stringArray) throws IOException, ParseException {
        URL uRL = new URL("http://example.com/your-static-file.txt");
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        Date date = simpleDateFormat.parse("Wed, 21 Jan 2020 14:30:00 GMT");
        httpURLConnection.setRequestProperty("If-Modified-Since", simpleDateFormat.format(date));
        int n = httpURLConnection.getResponseCode();
        if (n == 200) {
            System.out.println("File has been updated.");
        } else if (n == 304) {
            System.out.println("File hasn't been modified.");
        } else {
            System.out.println("Error: " + n);
        }
    }
}
