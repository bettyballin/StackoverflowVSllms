/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class MemoryEraser {
    public static void secureErase(Object[] objectArray) {
        if (objectArray == null) {
            return;
        }
        Arrays.fill(objectArray, null);
    }

    public static void main(String[] stringArray) {
    }
}
