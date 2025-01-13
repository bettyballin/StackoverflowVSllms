/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class GuidGenerator_2 {
    public static String generateGuidWithPrefix(String string) {
        UUID uUID = UUID.randomUUID();
        String string2 = uUID.toString();
        String string3 = string + string2.substring(8);
        return string3;
    }

    public static void main(String[] stringArray) {
        String string = "MY_PREFIX";
        String string2 = GuidGenerator_2.generateGuidWithPrefix(string);
        System.out.println(string2);
    }
}
