/*
 * Decompiled with CFR 0.152.
 */
import java.util.zip.CRC32;

public class Main_66 {
    public static void main(String[] stringArray) {
        CRC32 cRC32 = new CRC32();
        char[] cArray = "Hello, World!".toCharArray();
        cRC32.update(String.valueOf(cArray).getBytes());
        long l = cRC32.getValue();
        System.out.println(l);
    }
}
