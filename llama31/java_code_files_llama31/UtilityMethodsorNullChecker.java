/*
 * Decompiled with CFR 0.152.
 */
public class UtilityMethodsorNullChecker {
    public static boolean anyNull(Object ... objectArray) {
        for (Object object : objectArray) {
            if (object != null) continue;
            return true;
        }
        return false;
    }

    public static void main(String[] stringArray) {
    }
}
