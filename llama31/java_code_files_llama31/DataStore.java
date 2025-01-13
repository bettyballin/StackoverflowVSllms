/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataStore {
    public static void main(String[] stringArray) throws IOException {
        URL uRL = new URL("https://api.github.com/repos/username/repo/contents/file.csv");
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));){
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }
        }
        httpURLConnection.disconnect();
    }
}
