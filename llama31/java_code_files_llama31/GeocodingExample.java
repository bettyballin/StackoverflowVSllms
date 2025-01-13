/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeocodingExample {
    public static void main(String[] stringArray) throws Exception {
        String string = "1600 Amphitheatre Parkway, Mountain View, CA";
        String string2 = "YOUR_GOOGLE_MAPS_API_KEY";
        URL uRL = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" + string + "&key=" + string2);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int n = httpURLConnection.getResponseCode();
        if (n == 200) {
            String string3;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while ((string3 = bufferedReader.readLine()) != null) {
                stringBuffer.append(string3);
            }
            bufferedReader.close();
        } else {
            System.out.println("Failed to retrieve geocoding data");
        }
    }
}
