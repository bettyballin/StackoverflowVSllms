/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;
import java.net.URISyntaxException;

public class UrlUtil {
    public static String getDomain(String string) throws URISyntaxException {
        URI uRI = new URI(string);
        String string2 = uRI.getHost();
        if (string2.startsWith("www.")) {
            string2 = string2.substring(4);
        }
        return string2;
    }

    public static void main(String[] stringArray) {
    }
}
