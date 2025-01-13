/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class OnlineActivation {
    public static boolean isValidTrialPeriod(String string) throws IOException {
        URL uRL = new URL("https://your-server.com/validate-trial/" + string);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int n = httpURLConnection.getResponseCode();
        return n == 200;
    }

    public static void main(String[] stringArray) {
    }
}
