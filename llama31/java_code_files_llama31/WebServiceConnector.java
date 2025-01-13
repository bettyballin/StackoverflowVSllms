/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class WebServiceConnector {
    public static void main(String[] stringArray) throws IOException {
        URLConnection uRLConnection = new URL("https://example.com/webservice").openConnection();
        String string = "";
        uRLConnection.setRequestProperty("X-CSRF-Token", string);
    }
}
