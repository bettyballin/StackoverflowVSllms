/*
 * Decompiled with CFR 0.152.
 */
public class CrashJVM_1 {
    public static void main(String[] stringArray) {
        CrashJVM_1.recursiveMethod();
    }

    private static void recursiveMethod() {
        CrashJVM_1.recursiveMethod();
    }
}
