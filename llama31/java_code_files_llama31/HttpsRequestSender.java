/*
 * Decompiled with CFR 0.152.
 */
import java.io.OutputStreamWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class HttpsRequestSender {
    void sendRequest(String string) throws Exception {
        String string2 = "https://host.example.com/";
        URL uRL = new URL(string2);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection)uRL.openConnection();
        httpsURLConnection.setSSLSocketFactory(CustomSSLSocketFactory.getSSLSocketFactory("path/to/selfsignedcert.jks", "changeit"));
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setRequestProperty("Content-Length", String.valueOf(string.length()));
        httpsURLConnection.setDoOutput(true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream());
        outputStreamWriter.write(string);
        outputStreamWriter.flush();
    }

    public static void main(String[] stringArray) {
        HttpsRequestSender httpsRequestSender = new HttpsRequestSender();
        try {
            httpsRequestSender.sendRequest("Hello, World!");
        }
        catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
