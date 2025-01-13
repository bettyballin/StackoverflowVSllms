/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class UUIDExample {
    public static void main(String[] stringArray) {
        UUID uUID = UUID.randomUUID();
        String string = uUID.toString();
        String string2 = string.replace("-", "");
        System.out.println("UUID with hyphens: " + string);
        System.out.println("Compact UUID: " + string2);
    }
}
