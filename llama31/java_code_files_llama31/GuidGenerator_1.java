/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class GuidGenerator_1 {
    public static String generateGuid() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] stringArray) {
        System.out.println(GuidGenerator_1.generateGuid());
    }
}
