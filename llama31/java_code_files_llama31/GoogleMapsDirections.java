/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleMapsDirections {
    public static void main(String[] stringArray) throws Exception {
        String string = "YOUR_API_KEY";
        String string2 = "City+A";
        String string3 = "City+B";
        URL uRL = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + string2 + "&destination=" + string3 + "&mode=driving&key=" + string);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int n = httpURLConnection.getResponseCode();
        if (n == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String string4 = bufferedReader.readLine();
            System.out.println(string4);
        } else {
            System.out.println("Error: " + n);
        }
    }
}
