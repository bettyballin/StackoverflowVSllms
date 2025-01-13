/*
 * Decompiled with CFR 0.152.
 */
public class DebugModeChecker {
    public static void main(String[] stringArray) {
        String string = System.getProperty("debug.mode", "false");
        if (!Boolean.parseBoolean(string)) {
            System.out.println("Not in debug mode");
        } else {
            System.out.println("In debug mode");
        }
    }
}
