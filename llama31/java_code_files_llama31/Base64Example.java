/*
 * Decompiled with CFR 0.152.
 */
import java.util.Base64;

public class Base64Example {
    public static void main(String[] stringArray) {
        String string = "Hello, World!";
        String string2 = Base64.getEncoder().encodeToString(string.getBytes());
        System.out.println("Encoded: " + string2);
        byte[] byArray = Base64.getDecoder().decode(string2);
        String string3 = new String(byArray);
        System.out.println("Decoded: " + string3);
    }
}
