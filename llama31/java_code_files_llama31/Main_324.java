/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Main_324 {
    public static void main(String[] stringArray) throws IOException {
        URL uRL = new URL("https://example.com");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection)uRL.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        int n = httpsURLConnection.getResponseCode();
        if (n == 200) {
            String string;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }
            bufferedReader.close();
        } else {
            System.out.println("Failed to retrieve webpage");
        }
    }
}
