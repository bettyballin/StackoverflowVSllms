/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Main_133 {
    public static void main(String[] stringArray) throws Exception {
        URL uRL = new URL("https://example.com");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection)uRL.openConnection();
        httpsURLConnection.setHostnameVerifier((string, sSLSession) -> true);
        httpsURLConnection.connect();
    }
}
