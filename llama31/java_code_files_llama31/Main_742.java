/*
 * Decompiled with CFR 0.152.
 */
import java.util.Base64;

public class Main_742 {
    public static void main(String[] stringArray) {
        byte[] byArray = "Hello, World!".getBytes();
        String string = Base64.getEncoder().encodeToString(byArray);
        System.out.println("Encoded Data: " + string);
    }
}
