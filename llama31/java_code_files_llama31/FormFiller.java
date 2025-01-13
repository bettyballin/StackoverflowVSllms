/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FormFiller {
    public static void main(String[] stringArray) throws Exception {
        URL uRL = new URL("https://example.com/form");
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        String string = "field1=value1&field2=value2";
        try (Closeable closeable = new DataOutputStream(httpURLConnection.getOutputStream());){
            ((DataOutputStream)closeable).writeBytes(string);
        }
        closeable = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        try {
            String string2;
            while ((string2 = ((BufferedReader)closeable).readLine()) != null) {
                System.out.println(string2);
            }
        }
        finally {
            ((BufferedReader)closeable).close();
        }
    }
}
