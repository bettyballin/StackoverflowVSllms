/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class FormSubmitter {
    public static void main(String[] stringArray) throws Exception {
        URL uRL = new URL("https://example.com/form-action");
        URL uRL2 = new URL("https://example.com/referring-page");
        String string = "John";
        String string2 = "Doe";
        String string3 = "firstName=" + URLEncoder.encode(string, "UTF-8") + "&lastName=" + URLEncoder.encode(string2, "UTF-8");
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Referer", uRL2.toString());
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(string3.length()));
        httpURLConnection.setDoOutput(true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
        outputStreamWriter.write(string3);
        outputStreamWriter.flush();
        int n = httpURLConnection.getResponseCode();
        if (n == 200) {
            String string4;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ((string4 = bufferedReader.readLine()) != null) {
                System.out.println(string4);
            }
        } else {
            System.out.println("Error: " + n);
        }
    }
}
