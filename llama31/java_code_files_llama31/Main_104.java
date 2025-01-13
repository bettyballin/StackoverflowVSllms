/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main_104 {
    public static void main(String[] stringArray) {
        try {
            URL uRL = new URL("http://example.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            Object var3_4 = null;
            try (InputStream inputStream = httpURLConnection.getInputStream();
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));){
                String string;
                while ((string = bufferedReader.readLine()) != null) {
                    System.out.println(string);
                }
            }
            catch (Exception exception) {
                System.out.println("An error occurred: " + exception.getMessage());
            }
        }
        catch (Exception exception) {
            System.out.println("An error occurred: " + exception.getMessage());
        }
    }
}
