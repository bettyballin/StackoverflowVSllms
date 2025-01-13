/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.Charset;

public class CharsetChecker {
    public static void main(String[] stringArray) {
        String string = "Hello, World!";
        Charset charset = Charset.forName("UTF-8");
        if (charset.newEncoder().canEncode(string)) {
            System.out.println("String is UTF-8 encoded.");
        } else {
            System.out.println("String is not UTF-8 encoded.");
        }
    }
}
