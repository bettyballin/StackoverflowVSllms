/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;

public class ProxyTest {
    public static void main(String[] stringArray) throws Exception {
        URL uRL = new URL("https://ssl.site");
        Authenticator.setDefault(new Authenticator(){

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("proxy_username", "proxy_password".toCharArray());
            }
        });
        System.setProperty("http.proxyHost", "proxy.address");
        System.setProperty("http.proxyPort", "8080");
        URLConnection uRLConnection = uRL.openConnection();
        InputStream inputStream = uRLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String string = "";
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
    }
}
