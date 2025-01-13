import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRefererSpoofer {
    public void spoofReferer() throws Exception {
        URL url = new URL("http://www.example.com");

        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

        httpCon.setRequestProperty("Referer", "http://www.google.com");
    }

    public static void main(String[] args) throws Exception {
        HttpRefererSpoofer spoofer = new HttpRefererSpoofer();
        spoofer.spoofReferer();
    }
}