/*
 * Decompiled with CFR 0.152.
 */
public class ClassHierarchyChecker {
    public static boolean isSubclass(Class<?> clazz, Class<?> clazz2) {
        return clazz2.isAssignableFrom(clazz) && !clazz2.isInterface();
    }

    public static void main(String[] stringArray) {
    }
}
