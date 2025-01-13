/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {
    public void get(String string) throws Exception {
        URL uRL = new URL(string);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int n = httpURLConnection.getResponseCode();
        if (n == 200) {
            String string2;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while ((string2 = bufferedReader.readLine()) != null) {
                stringBuffer.append(string2);
            }
            bufferedReader.close();
            System.out.println(stringBuffer.toString());
        } else {
            System.out.println("Failed : HTTP error code : " + n);
        }
    }

    public static void main(String[] stringArray) {
        try {
            RestClient restClient = new RestClient();
            restClient.get("http://example.com");
        }
        catch (Exception exception) {
            System.out.println("Exception in main: " + exception.getMessage());
        }
    }
}
