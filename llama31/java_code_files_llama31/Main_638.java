/*
 * Decompiled with CFR 0.152.
 */
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main_638 {
    public static String encodeURIParameterValue(String string) throws Exception {
        String string2 = URLDecoder.decode(string, StandardCharsets.UTF_8.name());
        String string3 = URLEncoder.encode(string2, StandardCharsets.UTF_8.name()).replace("%20", "%2520").replace("%26", "%2526").replace("%3D", "%253D");
        return string3.replace(":", "%3A").replace("/", "%2F").replace("?", "%3F");
    }

    public static void main(String[] stringArray) throws Exception {
        String string = "http://google.com/resource?key=value1 & value2";
        String string2 = Main_638.encodeURIParameterValue(string);
        System.out.println(string2);
    }
}
