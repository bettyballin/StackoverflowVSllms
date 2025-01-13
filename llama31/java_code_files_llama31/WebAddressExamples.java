/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;
import java.net.URL;

public class WebAddressExamples {
    public static void main(String[] stringArray) throws Exception {
        URI uRI = new URI("mailto:user@example.com");
        System.out.println("URI: " + String.valueOf(uRI));
        URL uRL = new URL("https://www.example.com/path/to/resource");
        System.out.println("URL: " + String.valueOf(uRL));
        String string = "urn:isbn:0-486-27557-4";
        System.out.println("URN: " + string);
    }
}
