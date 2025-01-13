/*
 * Decompiled with CFR 0.152.
 */
import java.util.Base64;

public class Main_584 {
    public static void main(String[] stringArray) {
        byte[] byArray = new byte[33];
        String string = Base64.getEncoder().encodeToString(byArray);
        char[] cArray = string.toCharArray();
        System.out.println("Byte array length: " + byArray.length);
        System.out.println("Char array length: " + cArray.length);
    }
}
