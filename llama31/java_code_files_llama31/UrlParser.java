/*
 * Decompiled with CFR 0.152.
 */
import java.net.MalformedURLException;
import java.net.URL;

public class UrlParser {
    public static void main(String[] stringArray) {
        try {
            URL uRL = new URL("http://example.com#label");
            String string = uRL.getRef();
            System.out.println(string);
        }
        catch (MalformedURLException malformedURLException) {
            System.out.println("Invalid URL");
        }
    }
}
