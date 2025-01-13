/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;

public class Main_115 {
    public static boolean isValidUtf8(String string) {
        try {
            string.getBytes(StandardCharsets.UTF_8);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_115.isValidUtf8("Hello, World!"));
    }
}
