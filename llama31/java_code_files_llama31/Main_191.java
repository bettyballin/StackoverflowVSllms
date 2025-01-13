/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class Main_191 {
    public static String getUniqueFileName(String string, String string2) {
        return string + UUID.randomUUID().toString() + string2;
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_191.getUniqueFileName("/path/to/directory/", ".txt"));
    }
}
