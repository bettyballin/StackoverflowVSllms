/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;

public class AsciiConverter {
    public static void main(String[] stringArray) {
        byte[] byArray = new byte[]{116, 101, 115, 116};
        String string = new String(byArray, StandardCharsets.US_ASCII);
        System.out.print(string);
    }
}
