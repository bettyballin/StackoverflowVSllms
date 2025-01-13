/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.UUID;

public class Main_215 {
    public static void main(String[] stringArray) {
        SecureRandom secureRandom = new SecureRandom();
        UUID uUID = UUID.randomUUID();
        System.out.println(uUID.toString());
    }
}
