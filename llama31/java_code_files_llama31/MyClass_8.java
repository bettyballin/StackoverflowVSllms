/*
 * Decompiled with CFR 0.152.
 */
public class MyClass_8 {
    public static boolean isSubclass(Class<?> clazz, Class<?> clazz2) {
        return clazz2.isAssignableFrom(clazz);
    }

    public static void main(String[] stringArray) {
        System.out.println(MyClass_8.isSubclass(Integer.class, Number.class));
        System.out.println(MyClass_8.isSubclass(Number.class, Integer.class));
    }
}
