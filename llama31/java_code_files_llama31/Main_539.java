/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;
import java.net.URISyntaxException;

public class Main_539 {
    public static void main(String[] stringArray) {
        String string = "http://example.com";
        try {
            URI uRI = new URI(string);
            if (uRI.getScheme().equals("http") || uRI.getScheme().equals("https")) {
                System.out.println("URL is valid");
            } else {
                System.out.println("URL is invalid");
            }
        }
        catch (URISyntaxException uRISyntaxException) {
            System.out.println("Invalid URL syntax");
        }
    }
}
