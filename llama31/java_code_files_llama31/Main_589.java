/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main_589 {
    public static void main(String[] stringArray) {
        try {
            URL uRL = new URL("http://www.example.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            httpURLConnection.setRequestMethod("GET");
            int n = httpURLConnection.getResponseCode();
            if (n == 200) {
                String string;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                while ((string = bufferedReader.readLine()) != null) {
                    System.out.println(string);
                }
                bufferedReader.close();
            } else {
                System.out.println("Failed to retrieve content");
            }
        }
        catch (IOException iOException) {
            System.out.println("Error: " + iOException.getMessage());
        }
    }
}
