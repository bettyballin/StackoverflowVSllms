/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;
import java.net.URISyntaxException;

public class Main_810 {
    public static boolean isValidUrl(String string) {
        try {
            URI uRI = new URI(string);
            return uRI.getScheme() != null && uRI.getHost() != null;
        }
        catch (URISyntaxException uRISyntaxException) {
            return false;
        }
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_810.isValidUrl("http://www.example.com"));
        System.out.println(Main_810.isValidUrl("invalid url"));
    }
}
