/*
 * Decompiled with CFR 0.152.
 */
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Main_690 {
    public static void main(String[] stringArray) {
        String string = "Happy &amp; Sad";
        System.out.println(string);
        String string2 = URLDecoder.decode(string, StandardCharsets.UTF_8);
        System.out.println(string2);
    }
}
