/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InsuranceChecker {
    public static void main(String[] stringArray) throws Exception {
        String string = "123456789";
        String string2 = "https://example.com/insurance-check";
        URL uRL = new URL(string2);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.getOutputStream().write(("insuranceNumber=" + string).getBytes());
        int n = httpURLConnection.getResponseCode();
        if (n == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String string3 = bufferedReader.readLine();
            System.out.println("Insurance validity: " + string3);
        } else {
            System.out.println("Error: " + n);
        }
    }
}
