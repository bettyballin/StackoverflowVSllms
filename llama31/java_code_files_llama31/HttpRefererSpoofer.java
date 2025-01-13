/*
 * Decompiled with CFR 0.152.
 */
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRefererSpoofer {
    public void spoofReferer() throws Exception {
        URL uRL = new URL("http://www.example.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestProperty("Referer", "http://www.google.com");
    }

    public static void main(String[] stringArray) throws Exception {
        HttpRefererSpoofer httpRefererSpoofer = new HttpRefererSpoofer();
        httpRefererSpoofer.spoofReferer();
    }
}
